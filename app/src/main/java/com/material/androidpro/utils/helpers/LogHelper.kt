package com.material.androidpro.utils.helpers

import android.text.TextUtils
import android.util.Log

object LogHelper {

    private var LOG_ENABLED = true

    fun setLog(isLogEnabled: Boolean) {
        LOG_ENABLED = isLogEnabled
    }

    fun v(tag: String?, message: String?) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.v(tag, message!!)
        }
    }

    fun e(tag: String?, message: String?) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.e(tag, message!!)
        }
    }

    fun e(tag: String?, message: String?, ex: Exception?) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.e(tag, message, ex)
        }
    }

    fun e(tag: String?, message: String?, e: Error?) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.e(tag, message, e)
        }
    }

    fun d(tag: String?, message: String?) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.d(tag, message!!)
        }
    }

    fun i(tag: String?, message: String?) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.i(tag, message!!)
        }
    }

    fun w(tag: String?, message: String?) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.w(tag, message!!)
        }
    }

    fun w(tag: String?, message: String?, ex: Exception?) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.w(tag, message, ex)
        }
    }

}
