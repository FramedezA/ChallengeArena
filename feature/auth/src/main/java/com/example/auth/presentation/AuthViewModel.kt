package com.example.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.auth.domain.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository):ViewModel() {

    private val userIdMutable: MutableLiveData<Int> = MutableLiveData()
    val userId: LiveData<Int> = userIdMutable

    private val userIsLoggedMutable: MutableLiveData<Boolean> = MutableLiveData()
    val userIsLogged: LiveData<Boolean> = userIsLoggedMutable
    fun regNewUser(userName: String, login: String, password: String,confirmPassword:String) {
        viewModelScope.launch {
            repository.regNewUser(userName, login, password, confirmPassword , userIdMutable,userIsLoggedMutable)
        }
    }
//

//    fun getUser(id:Int) {
//        viewModelScope.launch {
//            repository.getUser(id)
//        }
//    }

}
class AuthViewModelFactory(private val authRepository: AuthRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        AuthViewModel(authRepository) as T
}
