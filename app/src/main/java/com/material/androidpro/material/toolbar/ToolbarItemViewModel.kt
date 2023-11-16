package com.material.androidpro.material.toolbar

import android.view.View
import androidx.databinding.ObservableField
import androidx.navigation.Navigation.findNavController
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.material.MaterialDesignFragmentDirections
import com.material.androidpro.material.MaterialModel

class ToolbarItemViewModel(model: MaterialModel) : ViewModel {

    @JvmField
    val mModel = ObservableField<MaterialModel>()

    init {
        mModel.set(model)
    }

    fun itemClick(view: View?) {
        val model = mModel.get()
        if (model != null) {
            val navController = findNavController(view!!)
            when (model.from) {
                ToolbarRetention.REGULAR -> {
                    val action1 =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToToolbarRegularFragment()
                    action1.title = model.title
                    navController.navigate(action1)
                }
                ToolbarRetention.CENTER_ALIGNED -> {
                    val action1 =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToToolbarCenterFragment()
                    action1.title = model.title
                    navController.navigate(action1)
                }
                ToolbarRetention.COLLAPSING_MEDIUM -> {
                    val action1 =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToCollapsingToolbarMediumFragment()
                    action1.title = model.title
                    navController.navigate(action1)
                }
                ToolbarRetention.COLLAPSING_LARGE -> {
                    val action1 =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToCollapsingToolbarLargeFragment()
                    action1.title = model.title
                    navController.navigate(action1)
                }
            }
        }
    }

    override fun close() {}

}