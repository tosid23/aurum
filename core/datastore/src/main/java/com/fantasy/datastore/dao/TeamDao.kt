package com.fantasy.datastore.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fantasy.data.team.Squad
import com.fantasy.data.team.TeamInfoEntity

@Dao
interface TeamDao {
    @Query("SELECT * FROM team_info_table")
    suspend fun getAllTeams(): List<TeamInfoEntity>?

    @Query("SELECT * FROM team_info_table where id = :teamId")
    suspend fun getTeamById(teamId: Long): TeamInfoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(team: TeamInfoEntity)

    @Query("UPDATE team_info_table SET currentSquad = :currentSquad WHERE id = :id")
    suspend fun updateCurrentSquad(id: Long, currentSquad: List<Squad>)
}