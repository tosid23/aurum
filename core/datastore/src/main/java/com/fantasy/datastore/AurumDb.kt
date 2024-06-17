package com.fantasy.datastore

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fantasy.datastore.data.TeamDao
import com.fantasy.datastore.data.TeamEntity

private const val DATABASE_VERSION = 1

@Database(
    entities = [TeamEntity::class],
    version = DATABASE_VERSION,
    exportSchema = true
)
@TypeConverters(
    Converters::class
)
abstract class AurumDb : RoomDatabase() {
    abstract fun teamDao(): TeamDao
}