package com.example.challenges.data

import android.content.Context
import android.content.SharedPreferences

class ChallengesStorageImpl(context: Context):ChallengesStorage
{
    override val defaultValue: String
        get() = ""

    private val userPreferences: SharedPreferences = context.getSharedPreferences("USERS_TABLE",Context.MODE_PRIVATE)

    override fun getUserName(): String = userPreferences.getString("name",defaultValue)!!
    override fun getId(): String=userPreferences.getString("id",defaultValue)!!


}