package com.example.fituai.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.domain.model.UserData
import com.example.fituai.domain.usecase.CalculateTDEE
import kotlinx.coroutines.launch

class ResultsViewModel(
    private val repository: FitnessRepository,
    private val calculateTDEE: CalculateTDEE
) : ViewModel() {

    private val _tdee = MutableLiveData<Double>()
    val tdee: LiveData<Double> = _tdee

    fun calcularTDEE() {
        viewModelScope.launch {
            val userData: UserData? = repository.getUserData()
            userData?.let {
                val resultado = calculateTDEE.execute(it)
                _tdee.value = resultado
            }
        }
    }
}
