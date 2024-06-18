package com.fantasy.datastore

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fantasy.data.team.TeamInfoEntity
import com.fantasy.data.element.ElementEntity
import com.fantasy.data.element.ElementTypeEntity
import com.fantasy.data.club.ClubEntity
import com.fantasy.datastore.dao.ElementDao
import com.fantasy.datastore.dao.ElementTypeDao
import com.fantasy.datastore.dao.TeamDao
import com.fantasy.datastore.dao.ClubDao

private const val DATABASE_VERSION = 1

@Database(
    entities = [TeamInfoEntity::class, ElementEntity::class, ElementTypeEntity::class, ClubEntity::class],
    version = DATABASE_VERSION,
    exportSchema = true
)
@TypeConverters(
    Converters::class
)
abstract class AurumDb : RoomDatabase() {
    abstract fun fplTeamDao(): TeamDao
    abstract fun elementDao(): ElementDao
    abstract fun teamDao(): ClubDao
    abstract fun elementTypeDao(): ElementTypeDao
}