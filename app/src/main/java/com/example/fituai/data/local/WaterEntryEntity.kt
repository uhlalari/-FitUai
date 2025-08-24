package com.example.fituai.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "water_entries")
data class WaterEntryEntity(
    @PrimaryKey val date: String,
    val amountMl: Int
)
