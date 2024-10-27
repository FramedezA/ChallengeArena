package com.example.network.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.network.data.data_structures.RefreshResponse
import kotlinx.coroutines.launch

class TokenViewModel(private val repository: TokenRepository) : ViewModel() {

    var refreshResponseMutableLiveData = MutableLiveData<RefreshResponse>()
    val refreshResponse: LiveData<RefreshResponse> = refreshResponseMutableLiveData


    fun getToken(): String? {
            return repository.getToken()
//        return "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJiIiwiaWQiOjEzLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiZXhwIjoxNzI5ODQ4Mjc3fQ.0LMmWOOhrF5T9HWcrrfZezbqV3C2E1yj2pnY9LVcaSkKdC4qqDR0h6r_MfvOr7E3"
    }


    fun setToken(token: String) {
        viewModelScope.launch {
            repository.setToken(token)
        }
    }


    fun clearToken() {
        viewModelScope.launch {
            repository.clearToken()

        }
    }


    fun isTokenValid(): Boolean {
        val token = getToken() ?: return false
        return token.isNotEmpty()
    }


    fun refreshToken(): Result<String> {
        // Предполагается, что у вас есть API для обновления токена
        // Здесь должен быть код для вызова API и обновления токена
        return try {
            repository.refreshTokens()
            // Пример: вызов API для обновления токена
            val newToken = "new_jwt_token_from_api"
            setToken(newToken)
            Result.success(newToken)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

class TokenViewModelFactory(private val tokenRepository: TokenRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        TokenViewModel(tokenRepository) as T
}