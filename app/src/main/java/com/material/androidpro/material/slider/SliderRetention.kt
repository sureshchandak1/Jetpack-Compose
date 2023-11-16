package com.material.androidpro.material.slider

import androidx.annotation.IntDef

interface SliderRetention {

    companion object {
        const val DEMO = 1
        const val COMPOSE_DEMO = 2
    }

    @IntDef(DEMO, COMPOSE_DEMO)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Slider
}