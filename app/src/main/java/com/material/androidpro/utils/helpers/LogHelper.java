package com.material.androidpro.utils.helpers;

import android.text.TextUtils;
import android.util.Log;

public class LogHelper {

    private static boolean LOG_ENABLED = true;

    public static void v(String tag, String message) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.v(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.e(tag, message);
        }
    }

    public static void e(String tag, String message, Exception ex) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.e(tag, message, ex);
        }
    }

    public static void e(String tag, String message, Error e) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.e(tag, message, e);
        }
    }

    public static void d(String tag, String message) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.i(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.w(tag, message);
        }
    }

    public static void w(String tag, String message, Exception ex) {
        if (LOG_ENABLED && !TextUtils.isEmpty(message)) {
            Log.w(tag, message, ex);
        }
    }

    public static void setLog(boolean isLogEnabled) {
        LOG_ENABLED = isLogEnabled;
    }

}
