package com.fantasy.datastore.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamDao {
    @Query("SELECT * FROM teams_table")
    suspend fun getAllTeams(): List<TeamEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(team: TeamEntity)
}