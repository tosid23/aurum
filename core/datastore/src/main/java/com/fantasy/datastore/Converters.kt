package com.fantasy.datastore

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {
    private val gson = Gson()

    @TypeConverter
    fun stringListFromStringNullable(value: String): List<String>? {
        val listType = object : TypeToken<List<String>?>() {
        }.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun stringListToString(list: List<String>?): String? {
        return gson.toJson(list)
    }

    @TypeConverter
    fun intListFromString(value: String?): List<Int>? {
        val listType = object : TypeToken<List<String>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun intListToString(list: List<Int>?): String? {
        return gson.toJson(list)
    }

//    @TypeConverter
//    fun fromStringToPlayersList(json: String): List<Players>? {
//        val listType = object : TypeToken<List<Players>?>() {}.type
//        return gson.fromJson(json, listType)
//    }
//
//    @TypeConverter
//    fun fromPlayersListToString(data: List<Players>): String = gson.toJson(data)
}
