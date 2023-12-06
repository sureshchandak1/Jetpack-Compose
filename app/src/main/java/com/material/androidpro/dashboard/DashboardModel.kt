package com.material.androidpro.dashboard

import com.material.androidpro.MaterialRetention.Material
import com.material.androidpro.compose.ui.ComposeUIRetention.ComposeUI

data class DashboardModel(

    @JvmField
    var image: Int = 0,

    @JvmField
    var title: String = "",

    @JvmField
    var shortDes: String = "",

    @Material
    var materialType: Int = 0,

    @ComposeUI
    var composeUIType: Int = 0

)
