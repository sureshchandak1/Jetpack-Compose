package com.material.androidpro.material.tabs

import androidx.annotation.IntDef

interface TabsRetention {

    companion object {
        const val DEMO = 1
        const val COMPOSE_DEMO = 2
    }

    @IntDef(DEMO, COMPOSE_DEMO)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Tabs
}