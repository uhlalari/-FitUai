package com.example.fituai.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.domain.model.UserData
import kotlinx.coroutines.launch

class WelcomeViewModel(private val repository: FitnessRepository) : ViewModel() {

    fun salvarDadosUsuario(
        idade: Int,
        peso: Float,
        altura: Float,
        genero: String,
        nivelAtividade: String,
        objetivo: String
    ) {
        val userData = UserData(idade, peso, altura, genero, nivelAtividade, objetivo)
        viewModelScope.launch {
            repository.saveUserData(userData)
        }
    }
}
