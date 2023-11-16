package com.material.androidpro.material.dialogs

import android.view.View
import androidx.databinding.ObservableField
import androidx.navigation.Navigation.findNavController
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.material.MaterialDesignFragmentDirections
import com.material.androidpro.material.MaterialModel

class DialogsItemViewModel(model: MaterialModel) : ViewModel {

    @JvmField
    val mModel = ObservableField<MaterialModel>()

    init {
        mModel.set(model)
    }

    fun itemClick(view: View?) {
        val model = mModel.get()
        if (model != null) {
            val navController = findNavController(view!!)
            if (model.from == DialogsRetention.ALERT_DIALOG) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToAlertDialogFragment()
                action1.title = model.title
                navController.navigate(action1)
            } else if (model.from == DialogsRetention.SIMPLE_DIALOG) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToSimpleDialogFragment()
                action1.title = model.title
                navController.navigate(action1)
            } else if (model.from == DialogsRetention.CONFIRMATION_DIALOG) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToConfirmationDialogFragment()
                action1.title = model.title
                navController.navigate(action1)
            } else if (model.from == DialogsRetention.COMPOSE_DEMO) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToAlertDialogComposeDemoFragment()
                action1.title = model.title
                navController.navigate(action1)
            }
        }
    }

    override fun close() {}

}