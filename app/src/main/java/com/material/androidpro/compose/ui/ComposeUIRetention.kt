package com.material.androidpro.compose.ui

import androidx.annotation.IntDef

interface ComposeUIRetention {

    companion object {
        const val PET_LIST = 1
        const val WATTER_BOTTLE = 2
        const val COMPOSE_MVVM = 3
        const val COMPOSE_NAVIGATION = 4
        const val MUSIC_STREAMING = 5
    }

    @IntDef(
        PET_LIST, WATTER_BOTTLE, COMPOSE_MVVM, COMPOSE_NAVIGATION, MUSIC_STREAMING
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class ComposeUI

}