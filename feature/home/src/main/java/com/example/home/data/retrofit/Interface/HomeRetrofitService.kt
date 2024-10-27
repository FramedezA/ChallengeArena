package com.example.home.data.retrofit.Interface


import com.example.home.data.data_structures.Challenge
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeRetrofitService {

    @GET("/api/v1/users/challenges/{id}")
    fun getChallenges(
        @Path("id") id:Int
    ): Call<List<Challenge>>
    // запрос на список челленджей

}