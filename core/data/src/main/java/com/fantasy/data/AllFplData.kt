package com.fantasy.data

import androidx.annotation.Keep
import com.fantasy.data.element.ElementEntity
import com.google.gson.annotations.SerializedName

@Keep
data class AllFplData(
    @SerializedName("elements") val elements: List<ElementEntity>,
)
