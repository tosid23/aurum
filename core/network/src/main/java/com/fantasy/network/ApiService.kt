package com.fantasy.network

import com.fantasy.data.AllFplData
import com.fantasy.data.FplTeamInfoData
import com.fantasy.data.FplTeamPicksData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("bootstrap-static/")
    suspend fun getGeneralData(): AllFplData

    @GET("entry/{team_id}/")
    suspend fun getTeamBasicInfoById(
        @Path("team_id") teamId: Long,
    ): FplTeamInfoData

    @GET("my-team/{team_id}/")
    suspend fun getTeamElementsInfoById(
        @Path("team_id") teamId: Long,
    ): FplTeamPicksData
}