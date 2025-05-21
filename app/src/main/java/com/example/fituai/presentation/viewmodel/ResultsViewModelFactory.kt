package com.example.fituai.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.domain.usecase.CalculateTDEE

class ResultsViewModelFactory(
    private val repository: FitnessRepository,
    private val calculateTDEE: CalculateTDEE
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultsViewModel::class.java)) {
            return ResultsViewModel(repository, calculateTDEE) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido")
    }
}
