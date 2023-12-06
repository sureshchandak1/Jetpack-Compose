package com.material.androidpro.model

import com.google.gson.annotations.SerializedName

data class BaseResponse(

    @SerializedName("success")
    var success: Boolean? = null,

    @SerializedName("message")
    var message: String? = null

)

