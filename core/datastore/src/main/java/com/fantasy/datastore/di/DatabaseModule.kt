package com.fantasy.datastore.di

import android.content.Context
import androidx.room.Room
import com.fantasy.datastore.AurumDb
import com.fantasy.datastore.dao.ElementDao
import com.fantasy.datastore.dao.ElementTypeDao
import com.fantasy.datastore.dao.TeamDao
import com.fantasy.datastore.dao.ClubDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideFplTeamDao(appDatabase: AurumDb): TeamDao = appDatabase.fplTeamDao()

    @Provides
    fun provideElementDao(appDatabase: AurumDb): ElementDao = appDatabase.elementDao()

    @Provides
    fun provideTeamDao(appDatabase: AurumDb): ClubDao = appDatabase.teamDao()

    @Provides
    fun provideElementTypeDao(appDatabase: AurumDb): ElementTypeDao = appDatabase.elementTypeDao()

    @Provides
    @Singleton
    fun provideAurumDatabase(@ApplicationContext appContext: Context): AurumDb {
        return Room.databaseBuilder(
            appContext,
            AurumDb::class.java,
            "aurum-database"
        ).fallbackToDestructiveMigration().build()
    }
}