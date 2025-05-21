package com.example.fituai.data.repository

import com.example.fituai.data.local.MockFoodDatabase
import com.example.fituai.domain.model.FoodItem

class FoodRepository {

    fun getAllFoods(): List<FoodItem> {
        return MockFoodDatabase.alimentos
    }
}
