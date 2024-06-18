package com.fantasy.feature.team.domain.repo

import com.fantasy.data.team.TeamInfoEntity
import com.fantasy.data.team.toTeamEntity
import com.fantasy.datastore.dao.ElementDao
import com.fantasy.datastore.dao.ElementTypeDao
import com.fantasy.datastore.dao.TeamDao
import com.fantasy.datastore.dao.ClubDao
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

    override suspend fun getFirstTeamFromDb(): TeamInfoEntity? {
        val teams = teamDao.getAllTeams()
        return teams?.firstOrNull()
    }

    override suspend fun getTeamDataFromApi(teamId: Long): TeamInfoEntity? {
        when (val data = enqueueRoutine { apiService.getTeamBasicInfoById(teamId) }) {
            is Result.Error -> return null

            is Result.Success -> {
                val teamData = data.data
                val teamEntity = teamData.toTeamEntity()
                //fplTeamDao.insertData(teamEntity)
                return teamEntity
            }
        }
    }
}