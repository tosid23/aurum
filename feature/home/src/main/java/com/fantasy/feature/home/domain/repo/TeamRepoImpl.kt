package com.fantasy.feature.home.domain.repo

import com.fantasy.data.model.TeamData
import com.fantasy.network.ApiService
import com.fantasy.network.Result
import com.fantasy.network.enqueueRoutine
import timber.log.Timber
import javax.inject.Inject

internal class TeamRepoImpl @Inject constructor(
    private val apiService: ApiService
) : TeamRepo {
    override suspend fun getTeamData(teamId: Long): Result<TeamData> {
        return enqueueRoutine { apiService.getYourTeamData(teamId) }
    }
}