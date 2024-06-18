package com.fantasy.data.element


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "element_type_table"
)
data class ElementTypeEntity(
    @PrimaryKey @SerializedName("id") val id: Int,
    @SerializedName("element_count") val elementCount: Double? = null,
    @SerializedName("plural_name") val pluralName: String?,
    @SerializedName("plural_name_short") val pluralNameShort: String?,
    @SerializedName("singular_name") val singularName: String?,
    @SerializedName("singular_name_short") val singularNameShort: String?,
    @SerializedName("squad_select") val squadSelect: Double? = null
)