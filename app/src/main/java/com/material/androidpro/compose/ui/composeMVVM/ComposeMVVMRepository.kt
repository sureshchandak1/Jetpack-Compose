package com.material.androidpro.compose.ui.composeMVVM

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ComposeMVVMRepository {

    val fullName = mutableStateOf("")
    val email = mutableStateOf("")
    val phoneNumber = mutableStateOf("")
    val password = mutableStateOf("")
    var passwordVisible by mutableStateOf(false)

}