package com.material.androidpro.compose.ui.composeMVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ComposeMVVMViewModelFactory(private val mRepository: ComposeMVVMRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ComposeMVVMViewModel(mRepository) as T
    }

}