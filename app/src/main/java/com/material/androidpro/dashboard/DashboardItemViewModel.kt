package com.material.androidpro.dashboard

import android.app.Activity
import android.view.View
import androidx.databinding.ObservableField
import androidx.navigation.Navigation.findNavController
import com.material.androidpro.adapters.ViewModel

class DashboardItemViewModel(private val mActivity: Activity, model: DashboardModel) : ViewModel {

    @JvmField
    val mModel = ObservableField<DashboardModel>()

    init {
        mModel.set(model)
    }

    fun itemClick(view: View?) {
        val model = mModel.get()
        if (model != null) {
            val action = DashboardFragmentDirections.actionDashboardFragmentToMaterialDesignFragment()
            action.setTitle(model.title)
            action.setShortDes(model.shortDes)
            action.setMaterialType(model.materialType)
            val navController = findNavController(view!!)
            //navController.navigate(R.id.action_dashboardFragment_to_materialDesignFragment);
            navController.navigate(action)
        }
    }

    override fun close() {}
}
