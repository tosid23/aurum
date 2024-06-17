package com.fantasy.feature.team.domain.repo

import com.fantasy.datastore.data.TeamEntity

interface TeamRepo {

    suspend fun getFirstTeamFromDb(): TeamEntity?

    suspend fun getTeamDataFromApi(teamId: Long): TeamEntity?
}