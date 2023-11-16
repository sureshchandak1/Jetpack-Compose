package com.material.androidpro.material.chips.demo

import android.content.Context
import android.view.View
import android.widget.Toast
import com.material.sharedcode.utils.AppUtils

class ChipsDemoViewModel internal constructor(private val mContext: Context) {

    @JvmField
    val closeClickListener = View.OnClickListener {
        val view: View = it
        AppUtils.showToast(mContext, "Close click", Toast.LENGTH_SHORT)
    }

}