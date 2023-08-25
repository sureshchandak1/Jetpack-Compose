package com.balaji.compose.view.login

import android.content.Context
import android.text.TextUtils
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class LoginRepository(private val mContext: Context) {

    var emailId by mutableStateOf("")
        private set
    var isEmailIdError by mutableStateOf(false)
    var emailError by mutableStateOf("")

    var password by mutableStateOf("")
        private set
    var isPasswordError by mutableStateOf(false)
    var passwordError by mutableStateOf("")

    fun updateEmailId(value: String) {
        emailId = value
        validation()
    }

    fun updatePassword(value: String) {
        password = value
        validation()
    }

    val loginClick: () -> Unit = {
        if (validation()) {

        }
    }

    private fun validation() : Boolean {
        val validEmail = !TextUtils.isEmpty(emailId)
        val validPassword = !TextUtils.isEmpty(password)

        var validSuccess = true
        if (validEmail) {
            isEmailIdError = false
            emailError = ""
            validSuccess = true
        } else {
            isEmailIdError = true
            emailError = "Please enter valid email id."
            validSuccess = false
        }

        if (validPassword) {
            isPasswordError = false
            passwordError = ""
            validSuccess = true
        } else {
            isPasswordError = true
            passwordError = "Please enter valid password."
            validSuccess = false
        }

        return validSuccess
    }
}