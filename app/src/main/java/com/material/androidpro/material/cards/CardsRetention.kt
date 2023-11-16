package com.material.androidpro.material.cards

import androidx.annotation.IntDef

interface CardsRetention {

    companion object {
        const val DEMO = 1
        const val COMPOSE_DEMO = 2
        const val CARD_IN_LAZY_COLUMN = 3
        const val CARD_EXPANDABLE = 4
        const val MY_SOOTHE = 5
        const val PAGING = 6
    }

    @IntDef(DEMO, COMPOSE_DEMO, CARD_IN_LAZY_COLUMN, CARD_EXPANDABLE, MY_SOOTHE, PAGING)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Cards

}