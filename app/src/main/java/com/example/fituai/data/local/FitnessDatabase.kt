package com.example.fituai.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UserDataEntity::class, FoodEntryEntity::class, WaterEntryEntity::class],
    version = 7
)
abstract class FitnessDatabase : RoomDatabase() {
    abstract fun userDataDao(): UserDataDao
    abstract fun foodEntryDao(): FoodEntryDao
    abstract fun waterEntryDao(): WaterEntryDao
}
