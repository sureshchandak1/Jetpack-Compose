package com.material.androidpro.common.profile

import com.material.androidpro.R
import com.material.androidpro.adapters.DataBindingRecyclerViewAdapter
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.common.EmptyItemViewModel

class ProfileAdapter internal constructor(viewModels: MutableList<ViewModel>) :
    DataBindingRecyclerViewAdapter(viewModels) {

    private val mViewModelMap: MutableMap<Class<*>, Int>

    init {
        mViewModelMap = HashMap()
        mViewModelMap[ProfileItemViewModel::class.java] = R.layout.profile_item
        mViewModelMap[MonthItemViewModel::class.java] = R.layout.month_item
        mViewModelMap[EmptyItemViewModel::class.java] = R.layout.empty_item
    }

    override val viewModelLayoutMap: Map<Class<*>, Int>
        get() = mViewModelMap

}