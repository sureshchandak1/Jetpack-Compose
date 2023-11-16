package com.material.androidpro.material.dialogs

import androidx.annotation.IntDef

interface DialogsRetention {

    companion object {
        const val ALERT_DIALOG = 1
        const val SIMPLE_DIALOG = 2
        const val CONFIRMATION_DIALOG = 3
        const val COMPOSE_DEMO = 4
    }

    @IntDef(ALERT_DIALOG, SIMPLE_DIALOG, CONFIRMATION_DIALOG, COMPOSE_DEMO)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Dialogs
}