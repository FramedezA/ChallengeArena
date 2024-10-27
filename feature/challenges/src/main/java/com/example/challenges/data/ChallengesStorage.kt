package com.example.challenges.data

interface ChallengesStorage {

    val defaultValue: String
    fun getUserName():String

    fun getId():String
}