package com.fantasy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "fpl_team_info_table"
)
data class FplTeamInfoEntity(
    @PrimaryKey val id: Long,
    val firstName: String,
    val lastName: String,
    val name: String,
    val joined: String,
    val currentEvent: Int,
    val currentEventPoints: Int,
    val currentEventRank: Long,
    val overallPoints: Int,
    val overallRank: Long,
    val lastDataUpdated: Long,
)

fun FplTeamInfoData.toTeamEntity() = FplTeamInfoEntity(
    id = id.toLong(),
    firstName = playerFirstName,
    lastName = playerLastName,
    name = name,
    joined = joinedTime,
    currentEvent = currentEvent,
    currentEventPoints = summaryEventPoints,
    currentEventRank = summaryEventRank.toLong(),
    overallPoints = summaryOverallPoints,
    overallRank = summaryOverallRank.toLong(),
    lastDataUpdated = System.currentTimeMillis()
)
