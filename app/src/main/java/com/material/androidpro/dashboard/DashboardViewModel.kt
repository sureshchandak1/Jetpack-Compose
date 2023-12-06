package com.material.androidpro.dashboard

import android.app.Activity
import androidx.databinding.ObservableField

class DashboardViewModel internal constructor(activity: Activity) {

    @JvmField
    val mAdapter = ObservableField<DashboardAdapter>()

    init {
        val adapter = DashboardAdapter(DashboardData.list(activity))
        mAdapter.set(adapter)
    }

}
