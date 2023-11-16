package com.material.androidpro.material.menus

import androidx.annotation.IntDef

interface MenusRetention {

    companion object {
        const val DEMO = 1
        const val COMPOSE_DEMO = 2
    }

    @IntDef(DEMO, COMPOSE_DEMO)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Menus
}