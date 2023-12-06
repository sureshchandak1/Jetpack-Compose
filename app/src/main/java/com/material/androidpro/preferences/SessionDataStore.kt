package com.material.androidpro.preferences

import android.content.Context
import android.content.SharedPreferences
import com.material.androidpro.utils.JsonKeys

object SessionDataStore {

    private const val PREF_NAME = "App_Session"

    private lateinit var preferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = preferences.edit()
    }

    fun getString(key: String?): String? {
        return preferences.getString(key, "")
    }

    fun setString(key: String?, value: String?) {
        editor.putString(key, value)
        editor.apply()
    }

    fun setInt(key: String?, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    fun getInt(key: String?): Int {
        return preferences.getInt(key, -1)
    }

    fun setBoolean(key: String?, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String?): Boolean {
        return preferences.getBoolean(key, false)
    }

    fun clearSession() {
        setString(JsonKeys.KEY_TOKEN, "")
        setString(JsonKeys.KEY_TOKEN_TYPE, "")
        setInt(JsonKeys.KEY_TOKEN_ID, -1)
        setString(JsonKeys.KEY_USER_ID, "")
        setBoolean(JsonKeys.KEY_IS_LOGIN, false)

        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}