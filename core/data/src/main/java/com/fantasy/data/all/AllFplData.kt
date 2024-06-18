package com.fantasy.data.all

import androidx.annotation.Keep
import com.fantasy.data.element.ElementEntity
import com.fantasy.data.element.ElementTypeEntity
import com.fantasy.data.club.ClubEntity
import com.google.gson.annotations.SerializedName

@Keep
data class AllFplData(
    @SerializedName("elements") val elements: List<ElementEntity>,
    @SerializedName("element_types") val elementTypes: List<ElementTypeEntity>,
    @SerializedName("teams") val teams: List<ClubEntity>,
)
