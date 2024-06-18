package com.fantasy.feature.team.di

import com.fantasy.datastore.dao.ElementDao
import com.fantasy.datastore.dao.FplTeamDao
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
        fplTeamDao: FplTeamDao,
        elementDao: ElementDao
    ): TeamRepo = TeamRepoImpl(apiService, fplTeamDao, elementDao)
}