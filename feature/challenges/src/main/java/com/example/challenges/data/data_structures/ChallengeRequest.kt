package com.example.challenges.data.data_structures

import com.google.gson.annotations.SerializedName

data class ChallengeRequest(
    @SerializedName("challengeId")
    val challengeId:Int,
    @SerializedName("userId")
    val userId:Int
)
