package com.fantasy.feature.home.domain.repo

import com.fantasy.data.model.TeamData
import com.fantasy.network.Result

interface TeamRepo {
    suspend fun getTeamData(teamId: Long): Result<TeamData>
}