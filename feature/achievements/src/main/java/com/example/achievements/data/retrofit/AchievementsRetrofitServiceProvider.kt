package com.example.achievements.data.retrofit

import com.example.achievements.data.retrofit.Interface.AchievementsRetrofitService
import com.example.network.RetrofitClient


object AchievementsRetrofitServiceProvider {
    val achievementsRetrofitService: AchievementsRetrofitService by lazy {
        RetrofitClient.getClient().create(AchievementsRetrofitService::class.java)
    }

}