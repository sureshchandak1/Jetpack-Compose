package com.material.androidpro.utils.helpers

object ExceptionHelper {

    private var EXCEPTION_ENABLED = true

    fun setException(isLogEnabled: Boolean) {
        EXCEPTION_ENABLED = isLogEnabled
    }

    fun printStackTrace(e: Exception) {
        if (EXCEPTION_ENABLED) {
            e.printStackTrace()
            LogHelper.e("exception", e.message)
        }
    }

    fun printStackTrace(e: Throwable) {
        if (EXCEPTION_ENABLED) {
            e.printStackTrace()
            LogHelper.e("exception", e.message)
        }
    }
}
