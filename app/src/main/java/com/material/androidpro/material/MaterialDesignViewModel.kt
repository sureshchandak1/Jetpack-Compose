package com.material.androidpro.material

import androidx.databinding.ObservableField
import com.material.androidpro.MaterialRetention
import com.material.androidpro.MaterialRetention.Material
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.material.MaterialDesignList.Companion.bottomAppBarList
import com.material.androidpro.material.MaterialDesignList.Companion.bottomNavList
import com.material.androidpro.material.MaterialDesignList.Companion.bottomSheetList
import com.material.androidpro.material.MaterialDesignList.Companion.buttonList
import com.material.androidpro.material.MaterialDesignList.Companion.cardsList
import com.material.androidpro.material.MaterialDesignList.Companion.checkboxList
import com.material.androidpro.material.MaterialDesignList.Companion.chipsList
import com.material.androidpro.material.MaterialDesignList.Companion.dialogsList
import com.material.androidpro.material.MaterialDesignList.Companion.menusList
import com.material.androidpro.material.MaterialDesignList.Companion.progressList
import com.material.androidpro.material.MaterialDesignList.Companion.sliderList
import com.material.androidpro.material.MaterialDesignList.Companion.switchList
import com.material.androidpro.material.MaterialDesignList.Companion.tabsList
import com.material.androidpro.material.MaterialDesignList.Companion.toolbarList

class MaterialDesignViewModel internal constructor(@Material materialType: Int) {

    @JvmField
    val shortDes = ObservableField<String>()
    @JvmField
    val mAdapter = ObservableField<MaterialDesignAdapter>()

    init {
        var viewModels: MutableList<ViewModel> = ArrayList()

        when (materialType) {
            MaterialRetention.ADAPTIVE -> {}
            MaterialRetention.BOTTOM_APP_BAR -> viewModels = bottomAppBarList()
            MaterialRetention.BOTTOM_SHEET -> viewModels = bottomSheetList()
            MaterialRetention.BUTTONS -> viewModels = buttonList()
            MaterialRetention.CARDS -> viewModels = cardsList()
            MaterialRetention.CHECKBOX -> viewModels = checkboxList()
            MaterialRetention.BOTTOM_NAVIGATION -> viewModels = bottomNavList()
            MaterialRetention.CHIPS -> viewModels = chipsList()
            MaterialRetention.DIALOGS -> viewModels = dialogsList()
            MaterialRetention.MENUS -> viewModels = menusList()
            MaterialRetention.PROGRESS -> viewModels = progressList()
            MaterialRetention.SLIDER -> viewModels = sliderList()
            MaterialRetention.SWITCH -> viewModels = switchList()
            MaterialRetention.TABS -> viewModels = tabsList()
            MaterialRetention.TOP_APP_BAR -> viewModels = toolbarList()
        }

        val adapter = MaterialDesignAdapter(viewModels = viewModels)
        mAdapter.set(adapter)
    }
}