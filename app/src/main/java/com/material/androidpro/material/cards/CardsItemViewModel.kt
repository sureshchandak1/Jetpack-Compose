package com.material.androidpro.material.cards

import android.view.View
import androidx.databinding.ObservableField
import androidx.navigation.Navigation.findNavController
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.material.MaterialDesignFragmentDirections
import com.material.androidpro.material.MaterialModel

class CardsItemViewModel(model: MaterialModel) : ViewModel {

    @JvmField
    val mModel = ObservableField<MaterialModel>()

    init {
        mModel.set(model)
    }

    fun itemClick(view: View?) {
        val model = mModel.get()
        if (model != null) {
            val navController = findNavController(view!!)
            if (model.from == CardsRetention.DEMO) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToCardDemoFragment()
                action1.title = model.title
                navController.navigate(action1)
            } else if (model.from == CardsRetention.COMPOSE_DEMO) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToCardComposeDemoFragment()
                action1.title = model.title
                navController.navigate(action1)
            } else if (model.from == CardsRetention.CARD_IN_LAZY_COLUMN) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToCardInLazyColumnFragment()
                action1.title = model.title
                navController.navigate(action1)
            } else if (model.from == CardsRetention.CARD_EXPANDABLE) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToCardExpandableFragment()
                action1.title = "Expandable"
                navController.navigate(action1)
            } else if (model.from == CardsRetention.MY_SOOTHE) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToMySootheUiFragment()
                action1.title = "MySoothe"
                navController.navigate(action1)
            } else if (model.from == CardsRetention.PAGING) {
                val action1 =
                    MaterialDesignFragmentDirections.actionMaterialDesignFragmentToCardPagingFragment()
                action1.title = model.title
                navController.navigate(action1)
            }
        }
    }

    override fun close() {}

}