package com.example.fituai.data.repository

import android.content.Context
import androidx.room.Room
import com.example.fituai.data.local.FitnessDatabase
import com.example.fituai.data.local.FoodEntryEntity
import com.example.fituai.data.local.UserDataEntity
import com.example.fituai.domain.model.UserData

class FitnessRepository(context: Context) {

    private val database: FitnessDatabase = Room.databaseBuilder(
        context.applicationContext,
        FitnessDatabase::class.java,
        "fitness_db"
    ).fallbackToDestructiveMigration()
        .build()

    private val userDataDao = database.userDataDao()
    private val foodEntryDao = database.foodEntryDao()

    suspend fun saveUserData(userData: UserData) {
        userDataDao.saveUserData(userData.toEntity())
    }

    suspend fun getUserData(): UserData? {
        return userDataDao.getUserData()?.toDomain()
    }

    suspend fun addFoodEntry(foodName: String, quantity: Int, calories: Int) {
        val entry = FoodEntryEntity(
            foodName = foodName,
            quantity = quantity,
            calories = calories
        )
        foodEntryDao.insertFoodEntry(entry)
    }

    suspend fun getAllFoodEntries(): List<FoodEntryEntity> =
        foodEntryDao.getAllFoodEntries()

    suspend fun clearFoodEntries() =
        foodEntryDao.clearAllEntries()

    suspend fun removeFoodEntry(foodName: String) =
        foodEntryDao.deleteByName(foodName)

    private fun UserData.toEntity() = UserDataEntity(
        id = 0,
        idade = idade,
        peso = peso,
        altura = altura,
        genero = genero,
        nivelAtividade = nivelAtividade,
        objetivo = objetivo
    )

    private fun UserDataEntity.toDomain() = UserData(
        idade = idade,
        peso = peso,
        altura = altura,
        genero = genero,
        nivelAtividade = nivelAtividade,
        objetivo = objetivo
    )
}
