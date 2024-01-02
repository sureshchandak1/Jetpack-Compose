package com.material.androidpro

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.google.firebase.FirebaseApp
import com.material.androidpro.preferences.SessionDataStore
import com.material.androidpro.preferences.SharedPreferencesManager
import com.material.androidpro.utils.JsonKeys
import com.material.androidpro.utils.helpers.ExceptionHelper
import com.material.androidpro.utils.helpers.LogHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppController : MultiDexApplication() {

    companion object {
        @get:Synchronized
        var instance: AppController? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        FirebaseApp.initializeApp(applicationContext)
        SharedPreferencesManager.init(this)
        SessionDataStore.init(this)
        val isDarkMode = SharedPreferencesManager.getBoolean(JsonKeys.KEY_IS_DARK_MODE)
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
        LogHelper.setLog(!BuildConfig.IS_PROD || BuildConfig.DEBUG)
        ExceptionHelper.setException(!BuildConfig.IS_PROD || BuildConfig.DEBUG)
    }

}
