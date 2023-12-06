package com.material.androidpro.apiclient

import com.material.androidpro.utils.AppUtil
import com.material.androidpro.utils.helpers.ExceptionHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response


fun <T> result(call: suspend () -> Response<T>) : Flow<ApiResponse<T?>> = flow {

    emit(ApiResponse.Loading)

    try {

        val response = call()
        response.let { res ->
            if (res.isSuccessful) {
                emit(ApiResponse.Success(res.body()))
            } else {
                val errorBody: ResponseBody? = res.errorBody()
                if (errorBody != null) {
                    errorBody.close()
                    val errorResponse = AppUtil.parseError(response)
                    val apiError = ApiError(
                        errorCode = "",
                        message = errorResponse.message!!,
                        meta = errorResponse.meta
                    )
                    emit(ApiResponse.Failure(apiError))
                }
            }
        }
    } catch (ex : HttpException) {
        ExceptionHelper.printStackTrace(ex)
        emit(ApiResponse.Failure(ApiError(ex.code().toString(), ex.message.toString())))
    } catch (t : Throwable) {
        ExceptionHelper.printStackTrace(t)
        emit(ApiResponse.Failure(ApiError("", t.message.toString())))
    }

}