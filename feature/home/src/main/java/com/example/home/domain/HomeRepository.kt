package com.example.home.domain

import androidx.lifecycle.MutableLiveData
import com.example.home.data.data_structures.Challenge


interface HomeRepository {

    fun getUserName():String

    fun getChallenges(challengesMutableLiveData : MutableLiveData<List<Challenge>>)
}