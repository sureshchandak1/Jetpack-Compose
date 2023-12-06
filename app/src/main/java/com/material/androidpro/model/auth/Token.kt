package com.material.androidpro.model.auth

import com.google.gson.annotations.SerializedName


data class Token(

    @SerializedName("access_token")
    var accessToken: String? = null,

    @SerializedName("token_type")
    var tokenType: String? = null,

    @SerializedName("token_id")
    var tokenId: Int? = null

)