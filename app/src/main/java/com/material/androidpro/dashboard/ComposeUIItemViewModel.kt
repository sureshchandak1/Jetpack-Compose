package com.material.androidpro.dashboard

import android.app.Activity
import android.view.View
import androidx.databinding.ObservableField
import androidx.navigation.Navigation
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.compose.ui.ComposeUIRetention

class ComposeUIItemViewModel(private val mActivity: Activity, model: DashboardModel) : ViewModel {

    @JvmField
    val mModel = ObservableField<DashboardModel>()

    init {
        mModel.set(model)
    }

    fun itemClick(view: View) {
        val model: DashboardModel? = mModel.get()
        if (model != null) {
            val navController = Navigation.findNavController(view)
            when (model.composeUIType) {
                ComposeUIRetention.PET_LIST -> {
                    val action = DashboardFragmentDirections.actionDashboardFragmentToPetListFragment()
                    navController.navigate(action)
                }
                ComposeUIRetention.WATTER_BOTTLE -> {
                    val action = DashboardFragmentDirections.actionDashboardFragmentToWatterBottleFragment()
                    navController.navigate(action)
                }
                ComposeUIRetention.COMPOSE_MVVM -> {
                    val action = DashboardFragmentDirections.actionDashboardFragmentToComposeMVVMFragment()
                    navController.navigate(action)
                }
            }
        }
    }

    override fun close() {}
}