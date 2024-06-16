package com.fantasy.network

import com.fantasy.data.model.TeamData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("entry/{team_id}/")
    suspend fun getYourTeamData(
        @Path("team_id") teamId: Long,
    ): TeamData
}