package com.fantasy.datastore.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fantasy.data.element.ElementEntity

@Dao
interface ElementDao {
    @Query("SELECT COUNT(*) FROM element_table")
    suspend fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(vararg team: ElementEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListData(list: List<ElementEntity>)
}