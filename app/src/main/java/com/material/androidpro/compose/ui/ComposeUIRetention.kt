package com.material.androidpro.compose.ui

import androidx.annotation.IntDef

interface ComposeUIRetention {

    companion object {
        const val PET_LIST = 1
    }

    @IntDef(
        PET_LIST
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class ComposeUI

}