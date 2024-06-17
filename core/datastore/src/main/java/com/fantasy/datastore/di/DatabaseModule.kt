package com.fantasy.datastore.di

import android.content.Context
import androidx.room.Room
import com.fantasy.datastore.AurumDb
import com.fantasy.datastore.data.TeamDao
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
    fun provideTripsDao(appDatabase: AurumDb): TeamDao = appDatabase.teamDao()

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