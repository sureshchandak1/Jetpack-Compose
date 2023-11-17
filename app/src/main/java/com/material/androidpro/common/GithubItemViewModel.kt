package com.material.androidpro.common

import android.view.View
import androidx.databinding.ObservableField
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.utils.CustomTabUtil

class GithubItemViewModel(name: String, private val mUrl: String) : ViewModel {

    @JvmField val mName = ObservableField(name)

    fun itemClick(view: View) {
        CustomTabUtil.launchUrl(view.context, mUrl)
    }
}