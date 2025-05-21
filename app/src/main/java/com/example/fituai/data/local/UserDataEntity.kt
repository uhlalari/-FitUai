package com.example.fituai.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class UserDataEntity(
    @PrimaryKey val id: Int = 0, // sempre 0, já que é só um usuário
    val idade: Int,
    val peso: Float,
    val altura: Float,
    val genero: String,
    val nivelAtividade: String,
    val objetivo: String
)
