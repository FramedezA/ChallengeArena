package com.example.home.data

import android.content.Context
import android.content.SharedPreferences

class HomeStorageImpl(context: Context):HomeStorage
{
    override val defaultValue: String
        get() = "0"

    private val userPreferences: SharedPreferences = context.getSharedPreferences("USERS_TABLE",Context.MODE_PRIVATE)

    override fun getUserName(): String = userPreferences.getString("name",defaultValue)!!
    override fun getId(): String=userPreferences.getString("id",defaultValue)!!


}