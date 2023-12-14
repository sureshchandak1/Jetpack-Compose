package com.material.androidpro.material.bottomnav

import androidx.annotation.IntDef

interface BottomNavRetention {

    companion object {
        const val DEMO = 1
        const val COMPOSE_DEMO = 2
        const val WITH_COMPOSE_NAVIGATION = 3
    }

    @IntDef(DEMO, COMPOSE_DEMO, WITH_COMPOSE_NAVIGATION)
    @Retention(AnnotationRetention.SOURCE)
    annotation class BottomNav
}