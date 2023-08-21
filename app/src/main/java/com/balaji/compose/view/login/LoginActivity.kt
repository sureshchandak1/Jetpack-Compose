package com.balaji.compose.view.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.balaji.compose.base.BaseActivity
import com.balaji.compose.ui.theme.ComposeTheme
import com.balaji.compose.view.login.ui.LoginScreen

class LoginActivity : BaseActivity() {

    private lateinit var mVm: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = LoginRepository()
        val factory = LoginViewModelFactory(repository)
        mVm = ViewModelProvider(this, factory)[LoginViewModel::class.java]

        setContent {
            ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

