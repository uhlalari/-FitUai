package com.example.fituai.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fituai.data.repository.FitnessRepository

class WelcomeViewModelFactory(private val repository: FitnessRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomeViewModel::class.java)) {
            return WelcomeViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido")
    }
}
