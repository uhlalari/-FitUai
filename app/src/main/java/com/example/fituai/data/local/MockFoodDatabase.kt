package com.example.fituai.data.local

import com.example.fituai.domain.model.FoodItem
import com.example.fituai.R

object MockFoodDatabase {

    val alimentos = listOf(
        FoodItem("Banana Prata", 89, R.drawable.ic_banana),
        FoodItem("Morango (100g)", 32, R.drawable.ic_morango),
        FoodItem("Iogurte (1 copo)", 150, R.drawable.ic_iogurte),
        FoodItem("Macarrão (100g)", 130, R.drawable.ic_macarrao),
        FoodItem("Hambúrguer Caseiro", 450, R.drawable.ic_hamburguer),
        FoodItem("Arroz (4 colheres)", 130, R.drawable.ic_arroz),
        FoodItem("Tapioca (2 colheres)", 70, R.drawable.ic_tapioca)
    )
}
