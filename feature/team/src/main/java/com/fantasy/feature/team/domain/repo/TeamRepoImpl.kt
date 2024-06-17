package com.fantasy.feature.team.domain.repo

import com.fantasy.datastore.data.TeamDao
import com.fantasy.datastore.data.TeamEntity
import com.fantasy.datastore.data.toTeamEntity
import com.fantasy.network.ApiService
import com.fantasy.network.Result
import com.fantasy.network.enqueueRoutine
import timber.log.Timber
import javax.inject.Inject

internal class TeamRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val teamDao: TeamDao
) : TeamRepo {
    override suspend fun getFirstTeamFromDb(): TeamEntity? {
        val teams = teamDao.getAllTeams()
        return teams?.firstOrNull()
    }

    override suspend fun getTeamDataFromApi(teamId: Long): TeamEntity? {
        when (val data = enqueueRoutine { apiService.getYourTeamData(teamId) }) {
            is Result.Error -> {
                Timber.e(data.errorMessage)
                return null
            }

            is Result.Success -> {
                val teamData = data.data
                val teamEntity = teamData.toTeamEntity()
                teamDao.insertData(teamEntity)
                return teamEntity
            }
        }
    }
}