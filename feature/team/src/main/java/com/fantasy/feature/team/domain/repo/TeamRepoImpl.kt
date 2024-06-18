package com.fantasy.feature.team.domain.repo

import com.fantasy.data.FplTeamInfoEntity
import com.fantasy.data.toTeamEntity
import com.fantasy.datastore.dao.ElementDao
import com.fantasy.datastore.dao.FplTeamDao
import com.fantasy.network.ApiService
import com.fantasy.network.Result
import com.fantasy.network.enqueueRoutine
import javax.inject.Inject

internal class TeamRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val fplTeamDao: FplTeamDao,
    private val elementDao: ElementDao
) : TeamRepo {
    override suspend fun isGeneralFplDataLoaded(): Boolean {
        return elementDao.getCount() > 0
    }

    override suspend fun getAllFplDataFromApi(): Boolean {
        return when (val data = enqueueRoutine { apiService.getGeneralData() }) {
            is Result.Error -> false
            is Result.Success -> {
                val allData = data.data
                allData.elements.let {
                    elementDao.insertListData(it)
                }
                true
            }
        }
    }

    override suspend fun getFirstTeamFromDb(): FplTeamInfoEntity? {
        val teams = fplTeamDao.getAllTeams()
        return teams?.firstOrNull()
    }

    override suspend fun getTeamDataFromApi(teamId: Long): FplTeamInfoEntity? {
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