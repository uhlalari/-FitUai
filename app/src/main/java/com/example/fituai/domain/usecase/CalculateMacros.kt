package com.example.fituai.domain.usecase

class CalculateMacros {

    enum class Goal { CUTTING, MAINTENANCE, BULKING }

    data class MacroResult(
        val adjustedCalories: Int,
        val proteinGrams: Int,
        val carbsGrams: Int,
        val fatGrams: Int
    )

    fun execute(tdee: Double, goalString: String?): MacroResult {
        val goal = parseGoal(goalString)
        val adjusted = when (goal) {
            Goal.CUTTING -> tdee * 0.80 // -20%
            Goal.MAINTENANCE -> tdee
            Goal.BULKING -> tdee * 1.15 // +15%
        }

        val (pPercent, fPercent, cPercent) = when (goal) {
            Goal.CUTTING -> Triple(0.30, 0.30, 0.40)
            Goal.MAINTENANCE -> Triple(0.25, 0.30, 0.45)
            Goal.BULKING -> Triple(0.25, 0.25, 0.50)
        }

        val protein = (adjusted * pPercent / 4.0).toInt()
        val fat = (adjusted * fPercent / 9.0).toInt()
        val carbs = (adjusted * cPercent / 4.0).toInt()

        return MacroResult(
            adjustedCalories = adjusted.toInt(),
            proteinGrams = protein,
            carbsGrams = carbs,
            fatGrams = fat
        )
    }

    private fun parseGoal(goalString: String?): Goal {
        return when (goalString?.lowercase()?.trim()) {
            "perder peso" -> Goal.CUTTING
            "manter peso" -> Goal.MAINTENANCE
            "ganhar peso" -> Goal.BULKING
            else -> Goal.MAINTENANCE
        }
    }
}
