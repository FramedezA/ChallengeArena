package com.example.auth.domain

import androidx.lifecycle.MutableLiveData

interface AuthRepository {


    fun regNewUser(
        userName: String,
        login: String,
        password: String,
        confirmPassword:String,
        userIdMutableLiveData: MutableLiveData<Int>,
        userIsLoggedMutableLiveData: MutableLiveData<Boolean>

    )

    fun login(
        login: String,
        password: String,
        userIsLoggedMutableLiveData: MutableLiveData<Boolean>
    )
//    fun getUser(
//        id:Int
//    )



}

