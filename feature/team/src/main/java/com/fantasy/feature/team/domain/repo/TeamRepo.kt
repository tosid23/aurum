package com.fantasy.feature.team.domain.repo

import com.fantasy.data.team.TeamInfoEntity

interface TeamRepo {

    suspend fun isGeneralFplDataLoaded(): Boolean

    suspend fun getAllFplDataFromApi(): Boolean?

    suspend fun getFirstTeamFromDb(): TeamInfoEntity?

    suspend fun getTeamDataFromApi(teamId: Long): TeamInfoEntity?
}