package com.material.androidpro.material.tabs.demo

import androidx.annotation.IntDef

interface TabsCountRetention {

    companion object {
        const val _3_TABS = 3
        const val _5_TABS = 5
        const val _10_TABS = 10
    }

    @IntDef(_3_TABS, _5_TABS, _10_TABS)
    @Retention(AnnotationRetention.SOURCE)
    annotation class TabsCount
}