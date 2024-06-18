package com.fantasy.feature.team.domain.repo

import com.fantasy.data.FplTeamInfoEntity

interface TeamRepo {

    suspend fun isGeneralFplDataLoaded(): Boolean

    suspend fun getAllFplDataFromApi(): Boolean?

    suspend fun getFirstTeamFromDb(): FplTeamInfoEntity?

    suspend fun getTeamDataFromApi(teamId: Long): FplTeamInfoEntity?
}