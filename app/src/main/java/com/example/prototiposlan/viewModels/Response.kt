package com.example.prototiposlan.viewModels

sealed class Response<out T> {
    object Loading:Response<Nothing>()

    data class Succes<out T>(
        val data: T?
    ):Response<T>()

    data class Failure<out T>(
        val e: Exception
    ):Response<T>()
}