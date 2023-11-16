package com.material.androidpro.common.profile

import androidx.databinding.ObservableField
import com.material.androidpro.adapters.ViewModel

class MonthItemViewModel(month: String) : ViewModel {

    val mMonth = ObservableField<String>()

    init {
        mMonth.set(month)
    }

    override fun close() {}

}