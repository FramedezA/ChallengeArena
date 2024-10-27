package com.example.challenges.data.retrofit.Interface


import com.example.challenges.data.data_structures.Challenge
import com.example.challenges.data.data_structures.ChallengeRequest
import com.example.challenges.data.data_structures.DatesToChallenges
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ChallengesRetrofitService {

    @POST("/api/v1/challenges")
    fun getChallengesByDate(
        @Body datesToChallenges: DatesToChallenges
    ): Call<List<Challenge>>

    @POST("/api/v1/users/add/challenge")
    fun setChallenge(
        @Body challengeRequest: ChallengeRequest
    ):Call<ChallengeRequest>

}