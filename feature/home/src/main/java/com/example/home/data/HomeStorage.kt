package com.example.home.data

interface HomeStorage {

    val defaultValue: String
    fun getUserName():String

    fun getId():String
}