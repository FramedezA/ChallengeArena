package com.example.challenges.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.challenges.data.data_structures.Challenge
import com.example.challenges.data.data_structures.ChallengeRequest
import com.example.challenges.domain.ChallengesRepository
import kotlinx.coroutines.launch

class ChallengesViewModel(private val repository: ChallengesRepository): ViewModel() {

    private val challengesMutableLiveData :MutableLiveData<List<Challenge>> = MutableLiveData()
    val challenges:LiveData<List<Challenge>> = challengesMutableLiveData

    private val challengeRequestMutableLiveData:MutableLiveData<ChallengeRequest> = MutableLiveData()
    val challengeRequest:LiveData<ChallengeRequest> = challengeRequestMutableLiveData

    fun getChallenges(date:String) {
        viewModelScope.launch {
            repository.getChallenges(date,challengesMutableLiveData)
        }
    }

    fun setChallenge(challenge: Challenge){
        viewModelScope.launch {
            repository.setChallenge(challenge.id,challengeRequestMutableLiveData)
        }
    }


}
class ChallengesViewModelFactory(private val challengesRepository: ChallengesRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ChallengesViewModel(challengesRepository) as T
}