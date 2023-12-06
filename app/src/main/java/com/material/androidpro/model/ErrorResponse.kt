package com.material.androidpro.model

import com.google.gson.annotations.SerializedName


data class ErrorResponse(

    @SerializedName("success")
    var success: Boolean? = null,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("meta")
    var meta: Meta? = null

) {

    data class Meta(

        @SerializedName("is_verify")
        var isVerify: Boolean = false

    )

}