package com.example.fituai.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class UserDataEntity(
    @PrimaryKey val id: Int = 0,
    val age: Int? = null,
    val weight: Float? = null,
    val height: Float? = null,
    val gender: String? = null,
    val activityLevel: String? = null,
    val goal: String? = null
)
