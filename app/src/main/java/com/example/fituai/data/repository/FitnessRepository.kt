package com.example.fituai.data.repository

import android.content.Context
import androidx.room.Room
import com.example.fituai.data.local.FitnessDatabase
import com.example.fituai.data.local.FoodEntryEntity
import com.example.fituai.data.local.UserDataEntity
import com.example.fituai.data.local.WaterEntryEntity
import com.example.fituai.domain.model.UserData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FitnessRepository(context: Context) {

    private val database: FitnessDatabase = Room.databaseBuilder(
        context.applicationContext,
        FitnessDatabase::class.java,
        "fitness_db"
    ).fallbackToDestructiveMigration()
        .build()

    private val userDataDao = database.userDataDao()
    private val foodEntryDao = database.foodEntryDao()
    private val waterEntryDao = database.waterEntryDao()

    suspend fun saveUserData(userData: UserData) {
        userDataDao.saveUserData(userData.toEntity())
    }

    suspend fun getUserData(): UserData? {
        return userDataDao.getUserData()?.toDomain()
    }

    suspend fun getFoodEntriesByDate(date: String = getToday()): List<FoodEntryEntity> =
        foodEntryDao.getEntriesByDate(date)

    suspend fun getFoodEntriesByDateAndMeal(date: String, mealType: String): List<FoodEntryEntity> =
        foodEntryDao.getEntriesByDateAndMeal(date, mealType)

    suspend fun removeFoodEntry(foodName: String) =
        foodEntryDao.deleteByName(foodName)

    suspend fun removeFoodEntry(foodName: String, date: String, mealType: String) =
        foodEntryDao.deleteByNameDateAndMeal(foodName, date, mealType)

    private fun UserData.toEntity() = UserDataEntity(
        id = 0,
        age = age,
        weight = weight,
        height = height,
        gender = gender,
        activityLevel = activityLevel,
        goal = goal
    )

    private fun UserDataEntity.toDomain() = UserData(
        age = age,
        weight = weight,
        height = height,
        gender = gender,
        activityLevel = activityLevel,
        goal = goal
    )

    companion object {
        fun getToday(): String {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            return sdf.format(Date())
        }
    }

    suspend fun upsertFoodEntry(
        foodName: String,
        quantity: Int,
        calories: Int,
        carbs: Int,
        protein: Int,
        fat: Int,
        mealType: String,
        date: String
    ) {
        val existingEntriesSameDateAndMeal = foodEntryDao.getEntriesByDateAndMeal(date, mealType)
        val existing = existingEntriesSameDateAndMeal.find { it.foodName == foodName }

        if (quantity == 0) {
            if (existing != null) {
                foodEntryDao.deleteByNameDateAndMeal(foodName, date, mealType)
            }
        } else {
            if (existing != null) {
                foodEntryDao.deleteByNameDateAndMeal(foodName, date, mealType)
            }

            val newEntry = FoodEntryEntity(
                foodName = foodName,
                quantity = quantity,
                calories = calories,
                carbs = carbs,
                protein = protein,
                fat = fat,
                mealType = mealType,
                date = date
            )
            foodEntryDao.insertFoodEntry(newEntry)
        }
    }

    suspend fun getWaterIntakeByDate(date: String = getToday()): Int {
        return waterEntryDao.getEntryByDate(date)?.amountMl ?: 0
    }

    suspend fun updateWaterIntake(date: String, deltaMl: Int) {
        val currentAmount = waterEntryDao.getEntryByDate(date)?.amountMl ?: 0
        val newAmount = (currentAmount + deltaMl).coerceAtLeast(0)
        waterEntryDao.insertOrUpdate(WaterEntryEntity(date, newAmount))
    }
}
