package com.material.androidpro;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.material.androidpro.preferences.SharedPreferencesManager;
import com.material.androidpro.utils.JsonKeys;
import com.material.androidpro.utils.helpers.ExceptionHelper;
import com.material.androidpro.utils.helpers.LogHelper;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class AppController extends MultiDexApplication {

    private static AppController mInstance;

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        SharedPreferencesManager.init(this);

        boolean isDarkMode = SharedPreferencesManager.getBoolean(JsonKeys.KEY_IS_DARK_MODE);
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        LogHelper.setLog(!BuildConfig.IS_PROD || BuildConfig.DEBUG);
        ExceptionHelper.setException(!BuildConfig.IS_PROD || BuildConfig.DEBUG);
    }

}
