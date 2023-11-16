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
            if (model.from == BottomNavRetention.DEMO) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomNavDemoFragment()
                action1.title = model.title
                navController.navigate(action1)
            } else if (model.from == BottomNavRetention.COMPOSE_DEMO) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomNavComposeDemoFragment()
                action1.title = model.title
                navController.navigate(action1)
            }
        }
    }

    override fun close() {}

}