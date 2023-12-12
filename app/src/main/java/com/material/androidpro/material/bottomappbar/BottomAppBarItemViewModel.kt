package com.material.androidpro.material.bottomappbar

import android.view.View
import androidx.databinding.ObservableField
import androidx.navigation.Navigation.findNavController
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.material.MaterialDesignFragmentDirections
import com.material.androidpro.material.MaterialModel

class BottomAppBarItemViewModel(model: MaterialModel) : ViewModel {

    @JvmField
    val mModel = ObservableField<MaterialModel>()

    init {
        mModel.set(model)
    }

    fun itemClick(view: View?) {
        val model = mModel.get()
        if (model != null) {
            val navController = findNavController(view!!)
            if (model.from == BottomAppBarRetention.DEMO) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomAppBarDemoFragment()
                action1.title = model.title
                navController.navigate(action1)
            } else if (model.from == BottomAppBarRetention.NAVIGATION_BAR) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomAppBarNavigationFragment()
                action1.title = model.title
                navController.navigate(action1)
            } else if (model.from == BottomAppBarRetention.COMPOSE_DEMO) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomNavComposeDemoFragment2()
                action1.title = model.title
                navController.navigate(action1)
            }
        }
    }

    override fun close() {}

}