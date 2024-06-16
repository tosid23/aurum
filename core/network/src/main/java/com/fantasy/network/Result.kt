package com.fantasy.network

import androidx.annotation.Keep

sealed class Result<out T> {
    @Keep
    data class Success<out T : Any>(val data: T) : Result<T>()

    @Keep
    data class Error<out T : Any>(
        val errorMessage: String?,
        val errorCode: Int,
        val data: String? = null
    ) : Result<T>()
}