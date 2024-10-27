package com.example.challenges.data.retrofit

import com.example.challenges.data.retrofit.Interface.ChallengesRetrofitService
import com.example.network.RetrofitClient


object ChallengesRetrofitServiceProvider {
    val challengesRetrofitService: ChallengesRetrofitService by lazy {
        RetrofitClient.getClient().create(ChallengesRetrofitService::class.java)
    }

}