package com.example.aisle.utils


import retrofit2.HttpException
import retrofit2.Response

/**
 * @Details Extension function for Retrofit
 */
fun <T> Response<T>.bodyOrThrow(): T {
    if (!isSuccessful) throw HttpException(this)
    return body()!!
}

