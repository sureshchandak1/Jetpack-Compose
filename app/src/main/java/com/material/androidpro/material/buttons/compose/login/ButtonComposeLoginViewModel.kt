package com.material.androidpro.material.buttons.compose.login

import android.content.Context
import android.widget.Toast

class ButtonComposeLoginViewModel(private val context: Context) {

    fun login(userId: String, password: String) {
        if (userId == "Jks" && password == "12345") {
            Toast.makeText(context, "logged!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Wrong credential", Toast.LENGTH_SHORT).show()
        }
    }

}