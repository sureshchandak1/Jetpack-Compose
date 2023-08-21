package com.balaji.compose.view.login

import com.balaji.compose.base.BaseViewModel

class LoginViewModel(repository: LoginRepository) : BaseViewModel() {

    val mRepository: LoginRepository

    init {
        mRepository = repository
    }
}