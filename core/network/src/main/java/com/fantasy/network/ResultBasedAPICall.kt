package com.fantasy.network

import retrofit2.HttpException
import timber.log.Timber

suspend fun <T : Any> enqueueRoutine(exe: suspend () -> T): Result<T> {
    return try {
        val result = Result.Success(exe.invoke())
        return result
    } catch (throwable: Throwable) {
        Timber.e(throwable)
        when (throwable) {
            is HttpException -> {
                Result.Error(
                    errorMessage = throwable.message,
                    errorCode = throwable.code(),
                )
            }

            else -> {
                Result.Error(
                    errorMessage = throwable.message,
                    errorCode = 0,
                )
            }
        }

    }
}
