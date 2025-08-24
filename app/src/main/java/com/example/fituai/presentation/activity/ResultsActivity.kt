package com.example.fituai.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.fituai.R
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.domain.usecase.CalculateTDEE
import com.example.fituai.presentation.viewmodel.ResultsViewModel
import com.example.fituai.presentation.viewmodel.ResultsViewModelFactory

class ResultsActivity : AppCompatActivity() {

    private lateinit var tvResultado: TextView
    private lateinit var btnInfo: ImageView
    private lateinit var btnContinuar: Button
    private lateinit var viewModel: ResultsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Resultados"
        }

        val repository = FitnessRepository(applicationContext)
        val calculateTDEE = CalculateTDEE()
        viewModel = ViewModelProvider(
            this,
            ResultsViewModelFactory(repository, calculateTDEE)
        )[ResultsViewModel::class.java]

        tvResultado = findViewById(R.id.tvResultado)
        btnInfo = findViewById(R.id.btnInfo)
        btnContinuar = findViewById(R.id.btnContinuar)

        btnContinuar.isEnabled = false

        viewModel.calculateTDEE()

        viewModel.tdee.observe(this) { tdee ->
            tvResultado.text = "Seu gasto calórico diário é: %.2f kcal".format(tdee)
            btnContinuar.isEnabled = tdee > 0.0
        }

        btnInfo.setOnClickListener {
            val bottomSheet = CalculationBottomSheet()
            bottomSheet.show(supportFragmentManager, "CalculationBottomSheet")
        }

        btnContinuar.setOnClickListener {
            val tdee = viewModel.tdee.value ?: 0.0
            val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
            prefs.edit().putBoolean("formulario_preenchido", true).apply()
            if (tdee > 0.0) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("TDEE", tdee)
                startActivity(intent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        goToWelcomeScreen()
        return true
    }

    override fun onBackPressed() {
        goToWelcomeScreen()
        super.onBackPressed()
    }

    private fun goToWelcomeScreen() {
        val intent = Intent(this, FormActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}
