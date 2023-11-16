package com.material.androidpro

import androidx.annotation.IntDef

interface MaterialRetention {

    companion object {
        const val ADAPTIVE = 1
        const val BOTTOM_APP_BAR = 2
        const val BOTTOM_SHEET = 3
        const val BUTTONS = 4
        const val CARDS = 5
        const val CHECKBOX = 6
        const val CHIPS = 7
        const val DIALOGS = 8
        const val MENUS = 9
        const val BOTTOM_NAVIGATION = 10
        const val PROGRESS = 11
        const val SLIDER = 12
        const val SWITCH = 13
        const val TABS = 14
        const val TOP_APP_BAR = 15
    }

    @IntDef(
        ADAPTIVE, BOTTOM_APP_BAR, BOTTOM_SHEET,
        BUTTONS, CARDS, CHECKBOX,
        CHIPS, DIALOGS, MENUS,
        BOTTOM_NAVIGATION, PROGRESS, SLIDER,
        SWITCH, TABS, TOP_APP_BAR
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class Material

}