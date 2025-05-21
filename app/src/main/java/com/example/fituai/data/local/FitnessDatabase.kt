package com.example.fituai.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserDataEntity::class, FoodEntryEntity::class], version = 1)
abstract class FitnessDatabase : RoomDatabase() {
    abstract fun userDataDao(): UserDataDao
    abstract fun foodEntryDao(): FoodEntryDao
}
