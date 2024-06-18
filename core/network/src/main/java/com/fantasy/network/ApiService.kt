package com.fantasy.network

import com.fantasy.data.all.AllFplData
import com.fantasy.data.team.TeamInfoData
import com.fantasy.data.team.TeamPicksData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("bootstrap-static/")
    suspend fun getGeneralData(): AllFplData

    @GET("entry/{team_id}/")
    suspend fun getTeamBasicInfoById(
        @Path("team_id") teamId: Long,
    ): TeamInfoData

    @GET("my-team/{team_id}/")
    suspend fun getTeamElementsInfoById(
        @Path("team_id") teamId: Long,
    ): TeamPicksData
}