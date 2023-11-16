package com.material.androidpro.material.switchs

import androidx.annotation.IntDef

interface SwitchRetention {

    companion object {
        const val DEMO = 1
        const val COMPOSE_DEMO = 2
    }

    @IntDef(DEMO, COMPOSE_DEMO)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Switch
}