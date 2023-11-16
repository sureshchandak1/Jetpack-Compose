package com.material.androidpro.material.switchs

import android.view.View
import androidx.databinding.ObservableField
import androidx.navigation.Navigation.findNavController
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.material.MaterialDesignFragmentDirections
import com.material.androidpro.material.MaterialModel

class SwitchItemViewModel(model: MaterialModel) : ViewModel {

    @JvmField
    val mModel = ObservableField<MaterialModel>()

    init {
        mModel.set(model)
    }

    fun itemClick(view: View?) {
        val model = mModel.get()
        if (model != null) {
            val navController = findNavController(view!!)
            if (model.from == SwitchRetention.DEMO) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToSwitchDemoFragment()
                action1.title = model.title
                navController.navigate(action1)
            } else if (model.from == SwitchRetention.COMPOSE_DEMO) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToSwitchComposeDemoFragment()
                action1.title = model.title
                navController.navigate(action1)
            }
        }
    }

    override fun close() {}

}