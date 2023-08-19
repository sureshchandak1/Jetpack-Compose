package com.balaji.compose

import android.content.Context
import android.content.Intent
import com.balaji.compose.view.login.LoginActivity
import com.balaji.compose.view.main.MainActivity

class AppNavigator {

    companion object {

        @JvmStatic
        fun navigateToLoginActivity(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }

        @JvmStatic
        fun navigateToMainActivity(context: Context, isPreviousClose: Boolean) {
            val intent = Intent(context, MainActivity::class.java)
            if (isPreviousClose) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
            context.startActivity(intent)
        }
    }

}