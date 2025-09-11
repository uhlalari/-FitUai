package com.example.fituai.presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.fituai.R
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.domain.usecase.CalculateMacros
import com.example.fituai.domain.usecase.CalculateTDEE
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.launch

class CalculationBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottomsheet_calculation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvBody = view.findViewById<TextView>(R.id.tvBody)
        val tvNote = view.findViewById<TextView>(R.id.tvNote)

        val repository = FitnessRepository(requireContext())

        viewLifecycleOwner.lifecycleScope.launch {
            val userData = repository.getUserData()
            val tdee = userData?.let { CalculateTDEE().execute(it) } ?: 2000.0
            val macros = CalculateMacros().execute(tdee, userData?.goal)

            val objetivo = (userData?.goal ?: "Manter Peso").trim()
            val titleEmoji = when (objetivo.lowercase()) {
                "perder peso" -> "📉 Perda de peso (Cutting)"
                "ganhar peso" -> "📈 Ganho de peso (Bulking)"
                else -> "⚖️ Manutenção"
            }
            tvTitle.text = titleEmoji

            val caloriasAlvo = macros.adjustedCalories
            val p = macros.proteinGrams
            val c = macros.carbsGrams
            val f = macros.fatGrams

            val corpo = when (objetivo.lowercase()) {
                "perder peso" -> buildString {
                    appendLine("Como calculamos")
                    appendLine("• TMB (Mifflin–St Jeor)")
                    appendLine("  • Homem: 88.36 + (13.4 × peso) + (4.8 × altura) − (5.7 × idade)")
                    appendLine("  • Mulher: 447.6 + (9.2 × peso) + (3.1 × altura) − (4.3 × idade)")
                    appendLine("• TDEE = TMB × fator de atividade")
                    appendLine("  (Sedentário 1.2 · Leve 1.375 · Moderado 1.55 · Ativo 1.725 · Muito ativo 1.9)")
                    appendLine("• Ajuste para perda: déficit de 20% → Calorias alvo = TDEE × 0.80")
                    appendLine("• Divisão de macronutrientes (AMDR)")
                    appendLine("  • 30% proteína · 30% gordura · 40% carboidrato")
                    appendLine("• Conversão para gramas (base ${caloriasAlvo} kcal)")
                    appendLine("  • proteína = (kcal × 0.30) ÷ 4  → ${p} g")
                    appendLine("  • gordura  = (kcal × 0.30) ÷ 9  → ${f} g")
                    appendLine("  • carbo    = (kcal × 0.40) ÷ 4  → ${c} g")
                    appendLine()
                    appendLine("Por que assim?")
                    appendLine("• Déficit moderado + proteína relativamente alta ajudam a preservar massa magra.")
                    appendLine("Referências")
                    appendLine("• Mifflin & St Jeor (1990); AMDR – IOM/USDA; ISSN.")
                }
                "ganhar peso" -> buildString {
                    appendLine("Como calculamos")
                    appendLine("• TMB (Mifflin–St Jeor)")
                    appendLine("• TDEE = TMB × fator de atividade")
                    appendLine("• Ajuste para ganho: superávit de 15% → Calorias alvo = TDEE × 1.15")
                    appendLine("• Divisão de macronutrientes (AMDR)")
                    appendLine("  • 25% proteína · 25% gordura · 50% carboidrato")
                    appendLine("• Conversão para gramas (base ${caloriasAlvo} kcal)")
                    appendLine("  • proteína = (kcal × 0.25) ÷ 4  → ${p} g")
                    appendLine("  • gordura  = (kcal × 0.25) ÷ 9  → ${f} g")
                    appendLine("  • carbo    = (kcal × 0.50) ÷ 4  → ${c} g")
                    appendLine()
                    appendLine("Por que assim?")
                    appendLine("• Superávit moderado + carbo alto favorecem performance e ganho com controle de gordura.")
                    appendLine("Referências")
                    appendLine("• Mifflin & St Jeor (1990); AMDR – IOM/USDA; ISSN (1.6–2.2 g/kg proteína em treino).")
                }
                else -> buildString {
                    appendLine("Como calculamos")
                    appendLine("• TMB (Mifflin–St Jeor)")
                    appendLine("• TDEE = TMB × fator de atividade")
                    appendLine("• Ajuste para manutenção: Calorias alvo = TDEE × 1.00")
                    appendLine("• Divisão de macronutrientes (AMDR)")
                    appendLine("  • 25% proteína · 30% gordura · 45% carboidrato")
                    appendLine("• Conversão para gramas (base ${caloriasAlvo} kcal)")
                    appendLine("  • proteína = (kcal × 0.25) ÷ 4  → ${p} g")
                    appendLine("  • gordura  = (kcal × 0.30) ÷ 9  → ${f} g")
                    appendLine("  • carbo    = (kcal × 0.45) ÷ 4  → ${c} g")
                    appendLine()
                    appendLine("Por que assim?")
                    appendLine("• Distribuição equilibrada dentro das faixas oficiais.")
                    appendLine("Referências")
                    appendLine("• Mifflin & St Jeor (1990); AMDR – IOM/USDA; OMS.")
                }
            }

            val nota = "Estes cálculos seguem Mifflin–St Jeor para gasto energético e faixas de macronutrientes da AMDR (IOM/USDA/OMS), com ajustes práticos adotados na literatura da ISSN. São estimativas para indivíduos saudáveis; para personalização clínica, procure um nutricionista."

            tvBody.text = corpo
            tvNote.text = nota
        }
    }
}
