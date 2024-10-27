package com.example.achievements.data

interface AchievementsStorage {

    val defaultValue: String
    fun getUserName():String

    fun getId():String
}