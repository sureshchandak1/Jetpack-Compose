package com.material.androidpro.material.toolbar

import androidx.annotation.IntDef

interface ToolbarRetention {

    companion object {
        const val REGULAR = 1
        const val CENTER_ALIGNED = 2
        const val COLLAPSING_MEDIUM = 3
        const val COLLAPSING_LARGE = 4
    }

    @IntDef(REGULAR, CENTER_ALIGNED, COLLAPSING_MEDIUM, COLLAPSING_LARGE)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Toolbar
}