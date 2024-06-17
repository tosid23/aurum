package com.fantasy.datastore.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fantasy.data.model.TeamData

@Entity(
    tableName = "teams_table"
)
data class TeamEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val joined: String,
    val points: Int,
    val rank: Long,
    val lastDataUpdated: Long,
)

fun TeamData.toTeamEntity() = TeamEntity(
    id = id.toLong(),
    name = name,
    joined = joinedTime,
    points = summaryEventPoints,
    rank = summaryEventRank.toLong(),
    lastDataUpdated = System.currentTimeMillis()
)
