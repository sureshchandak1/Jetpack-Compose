package com.material.androidpro.model.auth.login

import com.google.gson.annotations.SerializedName
import com.material.androidpro.model.auth.Token


data class LoginResponse(

    @SerializedName("data")
    var token: Token? = null,

    @SerializedName("success")
    var success: Boolean? = null,

    @SerializedName("message")
    var message: Any? = null

)