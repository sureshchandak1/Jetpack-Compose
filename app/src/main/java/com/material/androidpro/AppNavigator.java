package com.material.androidpro;

import android.content.Context;
import android.content.Intent;

import com.material.androidpro.dashboard.DashboardActivity;
import com.material.androidpro.splash.SplashActivity;

public final class AppNavigator {

    private AppNavigator() {
        throw new IllegalArgumentException(AppNavigator.class.getName());
    }

    public static void navigateToSplashActivity(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    public static void navigateToDashboardActivity(Context context) {
        Intent intent = new Intent(context, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

}
