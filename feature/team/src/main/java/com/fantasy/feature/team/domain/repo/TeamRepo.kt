package com.fantasy.feature.team.domain.repo

import com.fantasy.data.team.TeamInfoEntity

interface TeamRepo {

    suspend fun isGeneralFplDataLoaded(): Boolean

    suspend fun getFirstTeamIdFromDb(): Long?

    suspend fun getAllFplDataFromApi(): Boolean?

    suspend fun getTeamFromDb(teamId: Long): TeamInfoEntity?

    suspend fun getTeamDataFromApi(teamId: Long): Boolean

    suspend fun getTeamElementsInfoFromApi(teamId: Long): Boolean
}