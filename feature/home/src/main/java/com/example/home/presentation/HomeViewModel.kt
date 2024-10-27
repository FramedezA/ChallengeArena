package com.example.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.home.data.data_structures.Challenge
import com.example.home.domain.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository): ViewModel() {
//    private val loginCodeMutable: MutableLiveData<UserInfo> = MutableLiveData()
//    val loginCode: LiveData<UserInfo> = loginCodeMutable

//    private val userIsLoggedMutable: MutableLiveData<Boolean> = MutableLiveData()
//    val userIsLogged: LiveData<Boolean> = userIsLoggedMutable
//    fun login( login: String, password: String) {
//        viewModelScope.launch {
//            repository.login( login, password,userIsLoggedMutable)
//        }
//    }

    fun getUserName():String{
        return repository.getUserName()
    }



    private val challengesMutableLiveData : MutableLiveData<List<Challenge>> = MutableLiveData()
    val challenges: LiveData<List<Challenge>> = challengesMutableLiveData

    fun getChallenges() {
        viewModelScope.launch {
            repository.getChallenges(challengesMutableLiveData)
        }
    }


}
class HomeViewModelFactory(private val homeRepository: HomeRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        HomeViewModel(homeRepository) as T
}