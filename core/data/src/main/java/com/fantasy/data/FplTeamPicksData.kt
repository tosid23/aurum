package com.fantasy.data


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class FplTeamPicksData(
    @SerializedName("chips") val chips: List<Any>,
    @SerializedName("picks") val picks: List<FplTeamPlayers>,
    @SerializedName("transfers") val transfers: Transfers
)

@Keep
data class FplTeamPlayers(
    @SerializedName("element") val element: Int,
    @SerializedName("is_captain") val isCaptain: Boolean,
    @SerializedName("is_vice_captain") val isViceCaptain: Boolean,
    @SerializedName("multiplier") val multiplier: Int,
    @SerializedName("position") val position: Int,
    @SerializedName("purchase_price") val purchasePrice: Int,
    @SerializedName("selling_price") val sellingPrice: Int
)

@Keep
data class Transfers(
    @SerializedName("bank") val bank: Int,
    @SerializedName("cost") val cost: Int,
    @SerializedName("limit") val limit: Any?,
    @SerializedName("made") val made: Int,
    @SerializedName("status") val status: String,
    @SerializedName("value") val value: Int
)