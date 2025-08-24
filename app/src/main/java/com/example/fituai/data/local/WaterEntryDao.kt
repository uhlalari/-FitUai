package com.example.fituai.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WaterEntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(waterEntry: WaterEntryEntity)

    @Query("SELECT * FROM water_entries WHERE date = :date LIMIT 1")
    suspend fun getEntryByDate(date: String): WaterEntryEntity?

    @Query("DELETE FROM water_entries WHERE date = :date")
    suspend fun deleteByDate(date: String)
}
