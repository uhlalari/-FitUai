package com.example.fituai.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.fituai.R
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.domain.model.UserData
import com.example.fituai.presentation.viewmodel.WelcomeViewModel
import com.example.fituai.presentation.viewmodel.WelcomeViewModelFactory
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {

    private lateinit var viewModel: WelcomeViewModel
    private lateinit var etIdade: EditText
    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var spGenero: Spinner
    private lateinit var spNivelAtividade: Spinner
    private lateinit var spObjetivo: Spinner
    private lateinit var btnContinuar: Button
    private lateinit var btnInfo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        etIdade = findViewById(R.id.etIdade)
        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        spGenero = findViewById(R.id.spGenero)
        spNivelAtividade = findViewById(R.id.spNivelAtividade)
        spObjetivo = findViewById(R.id.spObjetivo)
        btnContinuar = findViewById(R.id.btnContinuar)
        btnInfo = findViewById(R.id.btnInfo)

        val repository = FitnessRepository(applicationContext)
        viewModel = ViewModelProvider(this, WelcomeViewModelFactory(repository))
            .get(WelcomeViewModel::class.java)

        lifecycleScope.launch {
            val userData = repository.getUserData()
            preencherCamposComDadosSalvos(userData)
        }

        btnContinuar.setOnClickListener {
            val idade = etIdade.text.toString().toIntOrNull() ?: return@setOnClickListener
            val peso = etPeso.text.toString().toFloatOrNull() ?: return@setOnClickListener
            val altura = etAltura.text.toString().toFloatOrNull() ?: return@setOnClickListener
            val genero = spGenero.selectedItem.toString()
            val nivelAtividade = spNivelAtividade.selectedItem.toString()
            val objetivo = spObjetivo.selectedItem.toString()

            viewModel.salvarDadosUsuario(idade, peso, altura, genero, nivelAtividade, objetivo)

            val intent = Intent(this, ResultsActivity::class.java)
            startActivity(intent)
        }

        btnInfo.setOnClickListener {
            InfoBottomSheet().show(supportFragmentManager, "InfoBottomSheet")
        }
    }

    private fun preencherCamposComDadosSalvos(userData: UserData?) {
        userData?.let {
            etIdade.setText(it.idade.toString())
            etPeso.setText(it.peso.toString())
            etAltura.setText(it.altura.toString())

            val generos = resources.getStringArray(R.array.genero_array)
            val niveis = resources.getStringArray(R.array.nivel_atividade_array)
            val objetivos = resources.getStringArray(R.array.objetivo_array)

            spGenero.setSelection(generos.indexOf(it.genero))
            spNivelAtividade.setSelection(niveis.indexOf(it.nivelAtividade))
            spObjetivo.setSelection(objetivos.indexOf(it.objetivo))
        }
    }
}
