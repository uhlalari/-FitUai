package com.example.fituai.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_entries")
data class FoodEntryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val foodName: String,
    val quantity: Int,
    val calories: Int,
    val carbs: Int,
    val protein: Int,
    val fat: Int,
    val mealType: String,
    val date: String
)
