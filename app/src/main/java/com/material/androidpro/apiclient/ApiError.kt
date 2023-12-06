package com.material.androidpro.apiclient

import com.material.androidpro.model.ErrorResponse

data class ApiError(
    val errorCode: String,
    val message: String,
    val meta: ErrorResponse.Meta? = null
)