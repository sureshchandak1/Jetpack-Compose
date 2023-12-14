package com.material.androidpro.material.bottomnav

import android.view.View
import androidx.databinding.ObservableField
import androidx.navigation.Navigation.findNavController
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.material.MaterialDesignFragmentDirections
import com.material.androidpro.material.MaterialModel

class BottomNavItemViewModel(model: MaterialModel) : ViewModel {

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
                BottomNavRetention.DEMO -> {
                    val action =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomNavDemoFragment()
                    action.title = model.title
                    navController.navigate(action)
                }
                BottomNavRetention.COMPOSE_DEMO -> {
                    val action =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomNavComposeDemoFragment()
                    action.title = model.title
                    navController.navigate(action)
                }
                BottomNavRetention.WITH_COMPOSE_NAVIGATION -> {
                    val action =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomNavWithNavigationFragment()
                    action.title = model.title
                    navController.navigate(action)
                }
            }
        }
    }

    override fun close() {}

}