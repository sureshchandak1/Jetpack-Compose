package com.material.androidpro.compose.ui

import androidx.annotation.IntDef

interface ComposeUIRetention {

    companion object {
        const val PET_LIST = 1
        const val WATTER_BOTTLE = 2
    }

    @IntDef(
        PET_LIST, WATTER_BOTTLE
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class ComposeUI

}