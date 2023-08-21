package com.balaji.compose.view.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.balaji.compose.AppNavigator
import com.balaji.compose.ui.theme.ComposeTheme
import com.balaji.compose.view.splash.ui.SplashScreen

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen()
                }
            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            AppNavigator.navigateToLoginActivity(this)
            finish()
        }, 1000)
    }

}
