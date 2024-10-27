package com.example.achievements.data.retrofit.Interface


import com.example.achievements.data.data_structures.Achievement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AchievementsRetrofitService {

    @GET("/api/v1/achievement/{id}")
    fun getAchievement(
        @Path("id")id:Int
    ):Call<List<Achievement>>

}