package com.fantasy.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class TeamData(
    @SerializedName("current_event") val currentEvent: Int,
    @SerializedName("favourite_team") val favouriteTeam: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("joined_time") val joinedTime: String,
    @SerializedName("kit") val kit: Any?,
    @SerializedName("last_deadline_bank") val lastDeadlineBank: Int,
    @SerializedName("last_deadline_total_transfers") val lastDeadlineTotalTransfers: Int,
    @SerializedName("last_deadline_value") val lastDeadlineValue: Int,
    @SerializedName("name") val name: String,
    @SerializedName("name_change_blocked") val nameChangeBlocked: Boolean,
    @SerializedName("player_first_name") val playerFirstName: String,
    @SerializedName("player_last_name") val playerLastName: String,
    @SerializedName("player_region_id") val playerRegionId: Int,
    @SerializedName("player_region_iso_code_long") val playerRegionIsoCodeLong: String,
    @SerializedName("player_region_iso_code_short") val playerRegionIsoCodeShort: String,
    @SerializedName("player_region_name") val playerRegionName: String,
    @SerializedName("started_event") val startedEvent: Int,
    @SerializedName("summary_event_points") val summaryEventPoints: Int,
    @SerializedName("summary_event_rank") val summaryEventRank: Int,
    @SerializedName("summary_overall_points") val summaryOverallPoints: Int,
    @SerializedName("summary_overall_rank") val summaryOverallRank: Int,
    @SerializedName("years_active") val yearsActive: Int
)