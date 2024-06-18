package com.fantasy.data.club


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "club_table"
)
data class ClubEntity(
    @PrimaryKey @SerializedName("id") val id: Int,
    @SerializedName("code") val code: Double? = null,
    @SerializedName("draw") val draw: Double? = null,
    @SerializedName("form") val form: Double? = null,
    @SerializedName("loss") val loss: Double? = null,
    @SerializedName("name") val name: String?,
    @SerializedName("played") val played: Double? = null,
    @SerializedName("points") val points: Double? = null,
    @SerializedName("position") val position: Double? = null,
    @SerializedName("pulse_id") val pulseId: Double? = null,
    @SerializedName("short_name") val shortName: String?,
    @SerializedName("strength") val strength: Double? = null,
    @SerializedName("strength_attack_away") val strengthAttackAway: Double? = null,
    @SerializedName("strength_attack_home") val strengthAttackHome: Double? = null,
    @SerializedName("strength_defence_away") val strengthDefenceAway: Double? = null,
    @SerializedName("strength_defence_home") val strengthDefenceHome: Double? = null,
    @SerializedName("strength_overall_away") val strengthOverallAway: Double? = null,
    @SerializedName("strength_overall_home") val strengthOverallHome: Double? = null,
    @SerializedName("unavailable") val unavailable: Boolean?,
    @SerializedName("win") val win: Double? = null
)