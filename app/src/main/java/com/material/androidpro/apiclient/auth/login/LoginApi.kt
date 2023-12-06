package com.material.androidpro.apiclient.auth.login

import com.material.androidpro.apiclient.ApiError
import com.material.androidpro.apiclient.ApiResponse
import com.material.androidpro.apiclient.RetrofitClient
import com.material.androidpro.apiclient.result
import com.material.androidpro.model.auth.Token
import com.material.androidpro.model.auth.login.LoginResponse
import com.material.androidpro.preferences.SessionDataStore
import com.material.androidpro.utils.JsonKeys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginApi(private val email: String?, private val pass: String?) {

    fun call(listener: RetrofitClient.Listener<LoginResponse, ApiError>) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = result { RetrofitClient.getClient().loginAPI(email, pass) }
            response.collect { apiResponse: ApiResponse<LoginResponse?> ->
                when(apiResponse) {
                    is ApiResponse.Success -> {
                        val res: LoginResponse? = apiResponse.response
                        if (res != null) {
                            val token: Token? = res.token
                            token?.let {
                                SessionDataStore.setString(JsonKeys.KEY_TOKEN, token.accessToken)
                                SessionDataStore.setString(JsonKeys.KEY_TOKEN_TYPE, token.tokenType)
                                SessionDataStore.setInt(JsonKeys.KEY_TOKEN_ID, token.tokenId!!)
                                listener.onResponse(res)
                            }
                        }
                    }

                    is ApiResponse.Failure -> {
                        CoroutineScope(Dispatchers.Main).launch {
                            listener.onError(apiResponse.error)
                        }
                    }

                    is ApiResponse.Loading -> {

                    }

                }
            }
        }

    }

}