package com.material.androidpro.common.places

import com.material.androidpro.R
import com.material.androidpro.adapters.DataBindingRecyclerViewAdapter
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.common.EmptyItemViewModel

class PlacesAdapter internal constructor(viewModels: MutableList<ViewModel>) :
    DataBindingRecyclerViewAdapter(viewModels) {

    private val mViewModelMap: MutableMap<Class<*>, Int>

    init {
        mViewModelMap = HashMap()
        mViewModelMap[PlacesItemViewModel::class.java] = R.layout.places_item
        mViewModelMap[EmptyItemViewModel::class.java] = R.layout.empty_item
    }

    override val viewModelLayoutMap: Map<Class<*>, Int>
        get() = mViewModelMap
}