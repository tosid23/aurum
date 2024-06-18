package com.fantasy.datastore.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fantasy.data.team.TeamInfoEntity

@Dao
interface TeamDao {
    @Query("SELECT * FROM team_info_table")
    suspend fun getAllTeams(): List<TeamInfoEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(team: TeamInfoEntity)
}