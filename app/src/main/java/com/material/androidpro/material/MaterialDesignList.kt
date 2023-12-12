package com.material.androidpro.material

import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.material.bottomappbar.BottomAppBarItemViewModel
import com.material.androidpro.material.bottomappbar.BottomAppBarRetention
import com.material.androidpro.material.bottomnav.BottomNavItemViewModel
import com.material.androidpro.material.bottomnav.BottomNavRetention
import com.material.androidpro.material.bottomsheet.BottomSheetItemViewModel
import com.material.androidpro.material.bottomsheet.BottomSheetRetention
import com.material.androidpro.material.buttons.ButtonItemViewModel
import com.material.androidpro.material.buttons.ButtonRetention
import com.material.androidpro.material.cards.CardsItemViewModel
import com.material.androidpro.material.cards.CardsRetention
import com.material.androidpro.material.checkboxes.CheckboxItemViewModel
import com.material.androidpro.material.checkboxes.CheckboxRetention
import com.material.androidpro.material.chips.ChipsItemViewModel
import com.material.androidpro.material.chips.ChipsRetention
import com.material.androidpro.material.dialogs.DialogsItemViewModel
import com.material.androidpro.material.dialogs.DialogsRetention
import com.material.androidpro.material.menus.MenusItemViewModel
import com.material.androidpro.material.menus.MenusRetention
import com.material.androidpro.material.progress.ProgressItemViewModel
import com.material.androidpro.material.progress.ProgressRetention
import com.material.androidpro.material.slider.SliderItemViewModel
import com.material.androidpro.material.slider.SliderRetention
import com.material.androidpro.material.switchs.SwitchItemViewModel
import com.material.androidpro.material.switchs.SwitchRetention
import com.material.androidpro.material.tabs.TabsItemViewModel
import com.material.androidpro.material.tabs.TabsRetention
import com.material.androidpro.material.toolbar.ToolbarItemViewModel
import com.material.androidpro.material.toolbar.ToolbarRetention

class MaterialDesignList private constructor() {

    init {
        throw IllegalArgumentException(MaterialDesignList::class.java.name)
    }

    companion object {

        @JvmStatic
        fun buttonList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", ButtonRetention.DEMO)
            viewModels.add(ButtonItemViewModel(model))

            model = MaterialModel("Toggle button", ButtonRetention.TOGGLE_BUTTON)
            viewModels.add(ButtonItemViewModel(model))

            model = MaterialModel("Theming buttons", ButtonRetention.THEMING_BUTTONS)
            viewModels.add(ButtonItemViewModel(model))

            model = MaterialModel("Compose Demo", ButtonRetention.COMPOSE_DEMO)
            viewModels.add(ButtonItemViewModel(model))

            model = MaterialModel("Compose Login", ButtonRetention.COMPOSE_LOGIN)
            viewModels.add(ButtonItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun bottomAppBarList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", BottomAppBarRetention.DEMO)
            viewModels.add(BottomAppBarItemViewModel(model))

            model = MaterialModel("with Navigation Bar", BottomAppBarRetention.NAVIGATION_BAR)
            viewModels.add(BottomAppBarItemViewModel(model))

            model = MaterialModel("Compose Bottom Navigation", BottomAppBarRetention.COMPOSE_DEMO)
            viewModels.add(BottomAppBarItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun bottomSheetList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", BottomSheetRetention.DEMO)
            viewModels.add(BottomSheetItemViewModel(model))

            model = MaterialModel("Modal Bottom Sheet", BottomSheetRetention.MODAL)
            viewModels.add(BottomSheetItemViewModel(model))

            model = MaterialModel("Persistent Bottom Sheet", BottomSheetRetention.PERSISTENT)
            viewModels.add(BottomSheetItemViewModel(model))

            model = MaterialModel("Full Screen Bottom Sheet", BottomSheetRetention.FULL_SCREEN)
            viewModels.add(BottomSheetItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun cardsList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", CardsRetention.DEMO)
            viewModels.add(CardsItemViewModel(model))

            model = MaterialModel("with Jetpack Paging", CardsRetention.PAGING)
            viewModels.add(CardsItemViewModel(model))

            model = MaterialModel("Compose Demo", CardsRetention.COMPOSE_DEMO)
            viewModels.add(CardsItemViewModel(model))

            model = MaterialModel("Card in LazyColumn", CardsRetention.CARD_IN_LAZY_COLUMN)
            viewModels.add(CardsItemViewModel(model))

            model = MaterialModel("Compose Card Expandable", CardsRetention.CARD_EXPANDABLE)
            viewModels.add(CardsItemViewModel(model))

            model = MaterialModel("Compose MySoothe UI", CardsRetention.MY_SOOTHE)
            viewModels.add(CardsItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun checkboxList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", CheckboxRetention.DEMO)
            viewModels.add(CheckboxItemViewModel(model))

            model = MaterialModel("Compose Demo", CheckboxRetention.COMPOSE_DEMO)
            viewModels.add(CheckboxItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun chipsList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", ChipsRetention.DEMO)
            viewModels.add(ChipsItemViewModel(model))

            model = MaterialModel("Compose Demo", ChipsRetention.COMPOSE_DEMO)
            viewModels.add(ChipsItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun dialogsList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Alert dialog", DialogsRetention.ALERT_DIALOG)
            viewModels.add(DialogsItemViewModel(model))

            model = MaterialModel("Simple dialog", DialogsRetention.SIMPLE_DIALOG)
            viewModels.add(DialogsItemViewModel(model))

            model = MaterialModel("Confirmation dialog", DialogsRetention.CONFIRMATION_DIALOG)
            viewModels.add(DialogsItemViewModel(model))

            model = MaterialModel("Compose Alert dialog", DialogsRetention.COMPOSE_DEMO)
            viewModels.add(DialogsItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun menusList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", MenusRetention.DEMO)
            viewModels.add(MenusItemViewModel(model))

            model = MaterialModel("Compose Demo", MenusRetention.COMPOSE_DEMO)
            viewModels.add(MenusItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun bottomNavList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", BottomNavRetention.DEMO)
            viewModels.add(BottomNavItemViewModel(model))

            model = MaterialModel("Compose Demo", BottomNavRetention.COMPOSE_DEMO)
            viewModels.add(BottomNavItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun progressList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", ProgressRetention.DEMO)
            viewModels.add(ProgressItemViewModel(model))

            model = MaterialModel("Compose Demo", ProgressRetention.COMPOSE_DEMO)
            viewModels.add(ProgressItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun sliderList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", SliderRetention.DEMO)
            viewModels.add(SliderItemViewModel(model))

            model = MaterialModel("Compose Demo", SliderRetention.COMPOSE_DEMO)
            viewModels.add(SliderItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun switchList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", SwitchRetention.DEMO)
            viewModels.add(SwitchItemViewModel(model))

            model = MaterialModel("Compose Demo", SwitchRetention.COMPOSE_DEMO)
            viewModels.add(SwitchItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun tabsList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Demo", TabsRetention.DEMO)
            viewModels.add(TabsItemViewModel(model))

            model = MaterialModel("Compose Demo", TabsRetention.COMPOSE_DEMO)
            viewModels.add(TabsItemViewModel(model))

            return viewModels
        }

        @JvmStatic
        fun toolbarList(): MutableList<ViewModel> {
            val viewModels: MutableList<ViewModel> = ArrayList()

            var model: MaterialModel? = null

            model = MaterialModel("Regular top app bars", ToolbarRetention.REGULAR)
            viewModels.add(ToolbarItemViewModel(model))

            model = MaterialModel("Center aligned top app bar", ToolbarRetention.CENTER_ALIGNED)
            viewModels.add(ToolbarItemViewModel(model))

            model = MaterialModel("Collapsing top app bars (Medium)", ToolbarRetention.COLLAPSING_MEDIUM)
            viewModels.add(ToolbarItemViewModel(model))

            model = MaterialModel("Collapsing top app bars (Large)", ToolbarRetention.COLLAPSING_LARGE)
            viewModels.add(ToolbarItemViewModel(model))

            return viewModels
        }
    }

}