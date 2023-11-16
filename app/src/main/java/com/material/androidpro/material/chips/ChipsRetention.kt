package com.material.androidpro.material.chips

import androidx.annotation.IntDef

interface ChipsRetention {

    companion object {
        const val DEMO = 1
        const val COMPOSE_DEMO = 2
    }

    @IntDef(DEMO, COMPOSE_DEMO)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Chips
}