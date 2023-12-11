package com.material.androidpro.dashboard

import android.app.Activity
import com.material.androidpro.MaterialRetention
import com.material.androidpro.R
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.common.EmptyItemViewModel
import com.material.androidpro.common.GithubItemViewModel
import com.material.androidpro.common.HeadingItemViewModel
import com.material.androidpro.compose.ui.ComposeUIRetention

class DashboardData private constructor() {

    init {
        throw IllegalArgumentException(DashboardData::class.java.name)
    }

    companion object {

        fun list(activity: Activity): MutableList<ViewModel> {

            val list: MutableList<ViewModel> = ArrayList()

            var model: DashboardModel? = null

            model = DashboardModel()
            model.image = R.drawable.ic_bottom_sheet
            model.title = "Bottom Sheets"
            model.shortDes =
                "Bottom sheets are surfaces containing supplementary content that are anchored to the bottom of the screen."
            model.materialType = MaterialRetention.BOTTOM_SHEET
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_bottom_app_bar
            model.title = "Bottom app bar"
            model.shortDes =
                "A bottom app bar displays navigation and key actions at the bottom of mobile screens."
            model.materialType = MaterialRetention.BOTTOM_APP_BAR
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_button
            model.title = "Buttons"
            model.shortDes =
                "Buttons allow users to take actions, and make choices, with a single tap."
            model.materialType = MaterialRetention.BUTTONS
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_cards
            model.title = "Cards"
            model.shortDes =
                "Cards contain content and actions that relate information about a subject."
            model.materialType = MaterialRetention.CARDS
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_checkbox
            model.title = "Checkboxes"
            model.shortDes =
                "Checkboxes allow users to select one or more items from a set. Checkboxes can turn an option on or off."
            model.materialType = MaterialRetention.CHECKBOX
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_chips
            model.title = "Chips"
            model.shortDes =
                "Chips help people enter information, make selections, filter content, or trigger actions. Chips can show multiple interactive elements together in the same area, such as a list of selectable movie times, or a series of email contacts."
            model.materialType = MaterialRetention.CHIPS
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_dialog
            model.title = "Dialogs"
            model.shortDes =
                "Dialogs provide important prompts in a user flow. They can require an action, communicate information, or help users accomplish a task."
            model.materialType = MaterialRetention.DIALOGS
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_menus
            model.title = "Menus"
            model.shortDes =
                "Menus display a list of choices on a temporary surface. They appear when users interact with a button, action, or other control."
            model.materialType = MaterialRetention.MENUS
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_bottom_nav
            model.title = "Bottom Navigation"
            model.shortDes =
                "Navigation bars offer a persistent and convenient way to switch between primary destinations in an app."
            model.materialType = MaterialRetention.BOTTOM_NAVIGATION
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_progress
            model.title = "Progress"
            model.shortDes =
                "Progress indicators express an unspecified wait time or display the length of a process."
            model.materialType = MaterialRetention.PROGRESS
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_slider
            model.title = "Slider"
            model.shortDes = "Sliders allow users to make selections from a range of values."
            model.materialType = MaterialRetention.SLIDER
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_switch
            model.title = "Switch"
            model.shortDes = "Switches toggle the state of a single item on or off."
            model.materialType = MaterialRetention.SWITCH
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_tabs
            model.title = "Tabs"
            model.shortDes =
                "Tabs organize content across different screens, data sets, and other interactions."
            model.materialType = MaterialRetention.TABS
            list.add(DashboardItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.ic_toolbar
            model.title = "Top App Bar"
            model.shortDes = "Top app bars display information and actions at the top of a screen."
            model.materialType = MaterialRetention.TOP_APP_BAR
            list.add(DashboardItemViewModel(activity, model))

            list.add(HeadingItemViewModel("Compose UI"))

            model = DashboardModel()
            model.image = R.drawable.dog_1
            model.title = "Pet List"
            model.shortDes = ""
            model.composeUIType = ComposeUIRetention.PET_LIST
            list.add(ComposeUIItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.water_bottle
            model.title = "Water Bottle"
            model.shortDes = ""
            model.composeUIType = ComposeUIRetention.WATTER_BOTTLE
            list.add(ComposeUIItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.water_bottle
            model.title = "Compose with MVVM"
            model.shortDes = ""
            model.composeUIType = ComposeUIRetention.COMPOSE_MVVM
            list.add(ComposeUIItemViewModel(activity, model))

            model = DashboardModel()
            model.image = R.drawable.water_bottle
            model.title = "Compose Navigation"
            model.shortDes = ""
            model.composeUIType = ComposeUIRetention.COMPOSE_NAVIGATION
            list.add(ComposeUIItemViewModel(activity, model))

            list.add(HeadingItemViewModel("GitHub"))

            list.add(
                GithubItemViewModel(
                    "kotlin-master",
                    "https://github.com/suresh000/kotlin-master"
                )
            )
            list.add(
                GithubItemViewModel(
                    "Jetpack-Compose",
                    "https://github.com/suresh000/Jetpack-Compose"
                )
            )
            list.add(
                GithubItemViewModel(
                    "Android-MVVM",
                    "https://github.com/suresh000/Android-MVVM"
                )
            )
            list.add(EmptyItemViewModel())

            return list
        }
    }
}
