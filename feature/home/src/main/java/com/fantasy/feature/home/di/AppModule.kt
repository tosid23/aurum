package com.fantasy.feature.home.di

import com.fantasy.feature.home.domain.repo.TeamRepo
import com.fantasy.feature.home.domain.repo.TeamRepoImpl
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
        apiService: ApiService
    ): TeamRepo = TeamRepoImpl(apiService)
}