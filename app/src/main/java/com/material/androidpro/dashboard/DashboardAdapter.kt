package com.material.androidpro.dashboard

import com.material.androidpro.R
import com.material.androidpro.adapters.DataBindingRecyclerViewAdapter
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.common.EmptyItemViewModel
import com.material.androidpro.common.HeadingItemViewModel

class DashboardAdapter internal constructor(viewModels: MutableList<ViewModel>) :
    DataBindingRecyclerViewAdapter(viewModels) {

    private val mViewModelMap: MutableMap<Class<*>, Int>

    init {
        mViewModelMap = HashMap()
        mViewModelMap[DashboardItemViewModel::class.java] = R.layout.dashboard_item
        mViewModelMap[ComposeUIItemViewModel::class.java] = R.layout.compose_ui_item
        mViewModelMap[HeadingItemViewModel::class.java] = R.layout.heading_item
        mViewModelMap[EmptyItemViewModel::class.java] = R.layout.empty_item
    }

    override val viewModelLayoutMap: Map<Class<*>, Int>
        get() = mViewModelMap

}