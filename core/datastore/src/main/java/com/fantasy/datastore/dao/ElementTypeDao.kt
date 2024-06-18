package com.fantasy.datastore.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.fantasy.data.element.ElementTypeEntity

@Dao
interface ElementTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListData(list: List<ElementTypeEntity>)
}