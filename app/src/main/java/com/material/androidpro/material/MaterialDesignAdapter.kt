package com.material.androidpro.material

import com.material.androidpro.R
import com.material.androidpro.adapters.DataBindingRecyclerViewAdapter
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.common.EmptyItemViewModel
import com.material.androidpro.material.bottomappbar.BottomAppBarItemViewModel
import com.material.androidpro.material.bottomnav.BottomNavItemViewModel
import com.material.androidpro.material.bottomsheet.BottomSheetItemViewModel
import com.material.androidpro.material.buttons.ButtonItemViewModel
import com.material.androidpro.material.cards.CardsItemViewModel
import com.material.androidpro.material.checkboxes.CheckboxItemViewModel
import com.material.androidpro.material.chips.ChipsItemViewModel
import com.material.androidpro.material.dialogs.DialogsItemViewModel
import com.material.androidpro.material.menus.MenusItemViewModel
import com.material.androidpro.material.progress.ProgressItemViewModel
import com.material.androidpro.material.slider.SliderItemViewModel
import com.material.androidpro.material.switchs.SwitchItemViewModel
import com.material.androidpro.material.tabs.TabsItemViewModel
import com.material.androidpro.material.toolbar.ToolbarItemViewModel

class MaterialDesignAdapter internal constructor(viewModels: MutableList<ViewModel>) :
    DataBindingRecyclerViewAdapter(viewModels) {

    private val mViewModelMap: MutableMap<Class<*>, Int>

    init {
        mViewModelMap = HashMap()
        mViewModelMap[ButtonItemViewModel::class.java] = R.layout.button_item
        mViewModelMap[BottomAppBarItemViewModel::class.java] = R.layout.bottom_app_bar_item
        mViewModelMap[BottomSheetItemViewModel::class.java] = R.layout.bottom_sheet_item
        mViewModelMap[CardsItemViewModel::class.java] = R.layout.cards_item
        mViewModelMap[CheckboxItemViewModel::class.java] = R.layout.checkbox_item
        mViewModelMap[ChipsItemViewModel::class.java] = R.layout.chips_item
        mViewModelMap[DialogsItemViewModel::class.java] = R.layout.dialogs_item
        mViewModelMap[MenusItemViewModel::class.java] = R.layout.menus_item
        mViewModelMap[BottomNavItemViewModel::class.java] = R.layout.bottom_nav_item
        mViewModelMap[ProgressItemViewModel::class.java] = R.layout.progress_item
        mViewModelMap[SliderItemViewModel::class.java] = R.layout.slider_item
        mViewModelMap[SwitchItemViewModel::class.java] = R.layout.switch_item
        mViewModelMap[TabsItemViewModel::class.java] = R.layout.tabs_item
        mViewModelMap[ToolbarItemViewModel::class.java] = R.layout.toolbar_item
        mViewModelMap[EmptyItemViewModel::class.java] = R.layout.empty_item
    }

    override val viewModelLayoutMap: Map<Class<*>, Int>
        get() = mViewModelMap

    fun addItems(viewModels: MutableList<ViewModel>) {
        mViewModels = viewModels
        notifyDataSetChanged()
    }

}