package com.material.androidpro.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.material.androidpro.AppNavigator
import com.material.androidpro.ui.theme.AppTheme
import com.material.androidpro.R

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Scaffold(
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting()
                    }
                }
            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            AppNavigator.navigateToDashboardActivity(this)
        }, 500)
    }
}

@Composable
fun Greeting() {
    Image(
        painter = painterResource(
            id = R.drawable.logo,
        ),
        contentDescription = "",
        Modifier.width(100.dp).height(100.dp),
        alignment = Alignment.Center
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        Scaffold(
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting()
            }
        }
    }
}