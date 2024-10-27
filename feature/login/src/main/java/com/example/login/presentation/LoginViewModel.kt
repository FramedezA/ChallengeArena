package com.example.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.data_structures.UserInfo
import com.example.login.domain.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository):ViewModel() {
    private val loginCodeMutable: MutableLiveData<UserInfo> = MutableLiveData()
    val loginCode: LiveData<UserInfo> = loginCodeMutable

    private val userIsLoggedMutable: MutableLiveData<Boolean> = MutableLiveData()
    val userIsLogged: LiveData<Boolean> = userIsLoggedMutable
    fun login( login: String, password: String) {
        viewModelScope.launch {
            repository.login( login, password,userIsLoggedMutable)
        }
    }
}
class LoginViewModelFactory(private val loginRepository: LoginRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        LoginViewModel(loginRepository) as T
}
