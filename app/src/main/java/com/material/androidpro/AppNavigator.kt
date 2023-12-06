package com.material.androidpro

import android.content.Context
import android.content.Intent
import com.material.androidpro.dashboard.DashboardActivity
import com.material.androidpro.splash.SplashActivity

class AppNavigator private constructor() {

    init {
        throw IllegalArgumentException(AppNavigator::class.java.name)
    }

    companion object {

        fun navigateToSplashActivity(context: Context) {
            val intent = Intent(context, SplashActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(intent)
        }

        fun navigateToDashboardActivity(context: Context) {
            val intent = Intent(context, DashboardActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(intent)
        }
    }
}
