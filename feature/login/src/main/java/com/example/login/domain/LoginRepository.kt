package com.example.login.domain

import androidx.lifecycle.MutableLiveData
import com.example.login.data.data_structures.UserInfo

interface LoginRepository {
    fun login(
        login: String,
        password: String,
        userIsLoggedMutableLiveData: MutableLiveData<Boolean>
    )

}

