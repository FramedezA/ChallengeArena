package com.example.auth.domain

import androidx.lifecycle.MutableLiveData

interface AuthRepository {


    fun regNewUser(
        userName: String,
        login: String,
        password: String,
        confirmPassword:String,
        userIdMutableLiveData: MutableLiveData<Int>
    )

//    fun login(
//        login: String,
//        password: String,
//    )
//    fun getUser(
//        id:Int
//    )



}

