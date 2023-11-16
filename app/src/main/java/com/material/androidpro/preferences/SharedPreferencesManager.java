package com.material.androidpro.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String PREF_NAME = "androidPro";

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public static void init(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static void putString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(String key) {
        return preferences.getString(key, "");
    }

    public static void putInteger(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInteger(String key) {
        return preferences.getInt(key, 0);
    }

    public static void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public static boolean getBooleanDefTrue(String key) {
        return preferences.getBoolean(key, true);
    }

}
