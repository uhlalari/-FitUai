package com.example.fituai.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodEntryDao {

    @Insert
    suspend fun insertFoodEntry(foodEntryEntity: FoodEntryEntity)

    @Query("SELECT * FROM food_entries")
    suspend fun getAllFoodEntries(): List<FoodEntryEntity>

    @Query("DELETE FROM food_entries")
    suspend fun clearAllEntries()

    @Query("DELETE FROM food_entries WHERE foodName = :name")
    suspend fun deleteByName(name: String)
}
