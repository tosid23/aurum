package com.fantasy.data.team

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "team_info_table"
)
data class TeamInfoEntity(
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

data class Squad(
    val element: Int,
    val firstName: String,
    val lastName: String,
    val isCaptain: Boolean,
    val isViceCaptain: Boolean,
    val multiplier: Int,
    val position: Int,
    val purchasePrice: Int,
    val sellingPrice: Int
)

fun TeamInfoData.toTeamEntity() = TeamInfoEntity(
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
