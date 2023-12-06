package com.material.androidpro.apiclient

import com.material.androidpro.model.auth.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    suspend fun loginAPI(
        @Field("email") email: String?,
        @Field("password") pass: String?
    ): Response<LoginResponse>

}