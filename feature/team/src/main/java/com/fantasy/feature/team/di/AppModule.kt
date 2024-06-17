package com.fantasy.feature.team.di

import com.fantasy.datastore.data.TeamDao
import com.fantasy.feature.team.domain.repo.TeamRepo
import com.fantasy.feature.team.domain.repo.TeamRepoImpl
import com.fantasy.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideTeamRepo(
        apiService: ApiService,
        teamDao: TeamDao
    ): TeamRepo = TeamRepoImpl(apiService, teamDao)
}