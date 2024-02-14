package com.example.ticketscanner.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ticketscanner.dataModel.LoginModel
import com.example.ticketscanner.services.LoginApiService
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val apiService = LoginApiService.create()

    fun login(username: String, password: String, onResult: (List<LoginModel>?) -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.login(username, password)
                onResult(response)
            } catch (e: Exception) {
                onResult(null)
            }
        }
    }
}