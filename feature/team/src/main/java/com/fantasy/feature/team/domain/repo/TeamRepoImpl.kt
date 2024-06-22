package com.fantasy.feature.team.domain.repo

import com.fantasy.data.team.Squad
import com.fantasy.data.team.addSquadPlayer
import com.fantasy.data.team.toTeamEntity
import com.fantasy.datastore.dao.ClubDao
import com.fantasy.datastore.dao.ElementDao
import com.fantasy.datastore.dao.ElementTypeDao
import com.fantasy.datastore.dao.TeamDao
import com.fantasy.network.ApiService
import com.fantasy.network.Result
import com.fantasy.network.enqueueRoutine
import javax.inject.Inject

internal class TeamRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val teamDao: TeamDao,
    private val elementDao: ElementDao,
    private val clubDao: ClubDao,
    private val elementTypeDao: ElementTypeDao
) : TeamRepo {
    override suspend fun isGeneralFplDataLoaded(): Boolean {
        return elementDao.getCount() > 0
    }

    override suspend fun getFirstTeamIdFromDb() = teamDao.getAllTeams()?.firstOrNull()?.id

    override suspend fun getAllFplDataFromApi(): Boolean {
        return when (val data = enqueueRoutine { apiService.getGeneralData() }) {
            is Result.Error -> false
            is Result.Success -> {
                val allData = data.data
                elementDao.insertListData(allData.elements)
                elementTypeDao.insertListData(allData.elementTypes)
                clubDao.insertListData(allData.teams)
                true
            }
        }
    }

    override suspend fun getTeamFromDb(teamId: Long) = teamDao.getTeamById(teamId)

    override suspend fun getTeamDataFromApi(teamId: Long): Boolean {
        return when (val data = enqueueRoutine { apiService.getTeamBasicInfoById(teamId) }) {
            is Result.Error -> false

            is Result.Success -> {
                val teamData = data.data
                val teamEntity = teamData.toTeamEntity()
                teamDao.insertData(teamEntity)
                getTeamElementsInfoFromApi(teamId)
                return true
            }
        }
    }

    override suspend fun getTeamElementsInfoFromApi(teamId: Long): Boolean {
        return when (val data = enqueueRoutine { apiService.getTeamElementsInfoById(teamId) }) {
            is Result.Error -> {
                false
            }

            is Result.Success -> {
                val currentPicks = data.data.picks
                val currentSquad = ArrayList<Squad>()
                currentPicks.forEach { pick ->
                    val element = elementDao.getElementDataById(pick.element.toLong())
                    val squadPlayer = addSquadPlayer(pick, element)
                    currentSquad.add(squadPlayer)
                }
                teamDao.updateCurrentSquad(teamId, currentSquad)
                true
            }
        }
    }
}