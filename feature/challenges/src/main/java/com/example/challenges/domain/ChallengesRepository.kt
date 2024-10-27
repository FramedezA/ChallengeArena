package com.example.challenges.domain

import androidx.lifecycle.MutableLiveData
import com.example.challenges.data.data_structures.Challenge
import com.example.challenges.data.data_structures.ChallengeRequest

interface ChallengesRepository {
    fun getChallenges(date:String,challengesMutableLiveData : MutableLiveData<List<Challenge>>)

    fun setChallenge(challengeId:Int,challengeRequestMutableLiveData: MutableLiveData<ChallengeRequest>)

}