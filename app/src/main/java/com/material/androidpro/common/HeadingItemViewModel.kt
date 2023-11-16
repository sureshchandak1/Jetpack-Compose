package com.material.androidpro.common

import androidx.databinding.ObservableField
import com.material.androidpro.adapters.ViewModel

class HeadingItemViewModel(text: String) : ViewModel {

    @JvmField
    val heading = ObservableField<String>()

    init {
        heading.set(text)
    }

    override fun close() {}
}