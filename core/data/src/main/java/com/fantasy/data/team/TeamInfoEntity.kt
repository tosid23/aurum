package com.fantasy.data.team

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fantasy.data.element.ElementEntity

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
    val currentSquad: List<Squad> = emptyList()
)

data class Squad(
    val element: Int,
    val firstName: String,
    val lastName: String,
    val photoUrl: String,
    val isCaptain: Boolean,
    val isViceCaptain: Boolean,
    val multiplier: Int,
    val position: Int,
    val purchasePrice: Int,
    val sellingPrice: Int,
    val currentEventPoints: Double
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

fun addSquadPlayer(teamPlayer: TeamPlayer, elementEntity: ElementEntity): Squad {
    return Squad(
        element = teamPlayer.element,
        firstName = elementEntity.firstName ?: "",
        lastName = elementEntity.secondName ?: "",
        photoUrl = "https://resources.premierleague.com/premierleague/photos/players/250x250/p${elementEntity.code}.png",
        isCaptain = teamPlayer.isCaptain,
        isViceCaptain = teamPlayer.isViceCaptain,
        multiplier = teamPlayer.multiplier,
        position = teamPlayer.position,
        purchasePrice = teamPlayer.purchasePrice,
        sellingPrice = teamPlayer.sellingPrice,
        currentEventPoints = elementEntity.eventPoints ?: 0.0
    )
}
