package com.example.challenges.data.data_structures

import com.google.gson.annotations.SerializedName

data class DatesToChallenges(
    @SerializedName("dateFrom")

    val dateFrom:String,
    @SerializedName("dateTo")

    val dateTo:String
)
