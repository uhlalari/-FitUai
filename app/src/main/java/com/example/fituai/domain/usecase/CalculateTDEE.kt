package com.example.fituai.domain.usecase

import com.example.fituai.domain.model.UserData

class CalculateTDEE {

    fun execute(userData: UserData): Double {
        val tmb = if (userData.genero == "Masculino") {
            88.36 + (13.4 * userData.peso) + (4.8 * userData.altura) - (5.7 * userData.idade)
        } else {
            447.6 + (9.2 * userData.peso) + (3.1 * userData.altura) - (4.3 * userData.idade)
        }

        val fatorAtividade = when (userData.nivelAtividade) {
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
