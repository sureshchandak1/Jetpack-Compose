package com.material.androidpro.apiclient

sealed class ApiResponse<out T> {
    data class Success<out S>(val response: S?) : ApiResponse<S>()
    data class Failure(val error: ApiError) : ApiResponse<Nothing>()
    data object Loading : ApiResponse<Nothing>()
}