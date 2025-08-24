package com.example.fituai.domain.usecase

import com.example.fituai.domain.model.UserData

class CalculateTDEE {

    fun execute(userData: UserData): Double {
        val age = userData.age
        val weight = userData.weight
        val height = userData.height
        val gender = userData.gender
        val activityLevel = userData.activityLevel

        if (age == null || weight == null || height == null || gender.isNullOrBlank() || activityLevel.isNullOrBlank()) {
            throw IllegalArgumentException("Todos os dados devem estar preenchidos para calcular o TDEE.")
        }

        val tmb = if (gender == "Masculino") {
            88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age)
        } else {
            447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age)
        }

        val fatorAtividade = when (activityLevel) {
            "Sedentário" -> 1.2
            "Leve" -> 1.375
            "Moderado" -> 1.55
            "Ativo" -> 1.725
            "Muito Ativo" -> 1.9
            else -> 1.2
        }

        return tmb * fatorAtividade
    }
}
