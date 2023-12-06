package com.material.androidpro.apiclient

import android.text.TextUtils
import com.google.gson.GsonBuilder
import com.material.androidpro.BuildConfig
import com.material.androidpro.preferences.SessionDataStore
import com.material.androidpro.utils.JsonKeys
import com.material.androidpro.utils.helpers.LogHelper
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val BASE_URL = BuildConfig.BASE_URL

    private val mRetrofit: Retrofit

    init {
        val gson = GsonBuilder()
            .setLenient()
            .serializeNulls()
            .create()

        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient().build())
            .build()
    }

    fun getRetrofit(): Retrofit {
        return mRetrofit
    }

    @Synchronized
    fun getClient() : ApiService {
        return mRetrofit.create(ApiService::class.java)
    }

    private fun httpClient(): OkHttpClient.Builder {
        val httpClient = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
        if (BuildConfig.IS_PROD) {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE)
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        // add logging as last interceptor
        httpClient.addInterceptor(logging)

        httpClient.callTimeout(60, TimeUnit.SECONDS)
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.writeTimeout(60, TimeUnit.SECONDS)

        httpClient.addInterceptor(Interceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
            val token = SessionDataStore.getString(JsonKeys.KEY_TOKEN).toString()
            val tokenType = SessionDataStore.getString(JsonKeys.KEY_TOKEN_TYPE).toString()
            LogHelper.d("Header-Authorization", "$tokenType $token")

            if (!TextUtils.isEmpty(token)) {
                requestBuilder.header("Authorization", "$tokenType $token")
            } else {
                requestBuilder.header("Authorization", "")
            }
            requestBuilder.header("Accept", "application/json")
            requestBuilder.header("Content-Type", "application/x-www-form-urlencoded")

            val originalHttpUrl = chain.request().url
            val url = originalHttpUrl.newBuilder().build()
            requestBuilder.url(url)

            val request: Request = requestBuilder.build()
            chain.proceed(request)
        })

        return httpClient
    }

    interface Listener<T, U> {
        fun onResponse(response: T)
        fun onError(error: U)
    }

}