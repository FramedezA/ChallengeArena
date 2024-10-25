package com.example.core.data_structures

data class Response<T>(
    val statusCode: Int,
    val message: String,
    val data: T
)
