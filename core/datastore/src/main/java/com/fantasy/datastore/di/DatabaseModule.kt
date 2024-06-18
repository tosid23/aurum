package com.fantasy.datastore.di

import android.content.Context
import androidx.room.Room
import com.fantasy.datastore.AurumDb
import com.fantasy.datastore.dao.ElementDao
import com.fantasy.datastore.dao.FplTeamDao
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
    fun provideFplTeamDao(appDatabase: AurumDb): FplTeamDao = appDatabase.fplTeamDao()

    @Provides
    fun provideElementDao(appDatabase: AurumDb): ElementDao = appDatabase.elementDao()

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