package com.fantasy.datastore.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fantasy.data.FplTeamInfoEntity

@Dao
interface FplTeamDao {
    @Query("SELECT * FROM fpl_team_info_table")
    suspend fun getAllTeams(): List<FplTeamInfoEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(team: FplTeamInfoEntity)
}