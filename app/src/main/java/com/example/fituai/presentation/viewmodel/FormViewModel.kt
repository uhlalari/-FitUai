package com.example.fituai.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.domain.model.UserData
import kotlinx.coroutines.launch

class FormViewModel(private val repository: FitnessRepository) : ViewModel() {

    fun saveAge(age: Int) {
        viewModelScope.launch {
            val current = repository.getUserData() ?: UserData()
            val updated = current.copy(age = age)
            repository.saveUserData(updated)
        }
    }

    fun saveWeight(weight: Float) {
        viewModelScope.launch {
            val current = repository.getUserData() ?: UserData()
            val updated = current.copy(weight = weight)
            repository.saveUserData(updated)
        }
    }

    fun saveHeight(height: Float) {
        viewModelScope.launch {
            val current = repository.getUserData() ?: UserData()
            val updated = current.copy(height = height)
            repository.saveUserData(updated)
        }
    }

    fun saveGender(gender: String) {
        viewModelScope.launch {
            val current = repository.getUserData() ?: UserData()
            val updated = current.copy(gender = gender)
            repository.saveUserData(updated)
        }
    }

    fun saveActivityLevel(level: String) {
        viewModelScope.launch {
            val current = repository.getUserData() ?: UserData()
            val updated = current.copy(activityLevel = level)
            repository.saveUserData(updated)
        }
    }

    fun saveGoal(goal: String) {
        viewModelScope.launch {
            val current = repository.getUserData() ?: UserData()
            val updated = current.copy(goal = goal)
            repository.saveUserData(updated)
        }
    }
}
