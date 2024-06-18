package com.fantasy.datastore

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fantasy.data.FplTeamInfoEntity
import com.fantasy.data.element.ElementEntity
import com.fantasy.datastore.dao.ElementDao
import com.fantasy.datastore.dao.FplTeamDao

private const val DATABASE_VERSION = 1

@Database(
    entities = [FplTeamInfoEntity::class, ElementEntity::class],
    version = DATABASE_VERSION,
    exportSchema = true
)
@TypeConverters(
    Converters::class
)
abstract class AurumDb : RoomDatabase() {
    abstract fun fplTeamDao(): FplTeamDao
    abstract fun elementDao(): ElementDao
}