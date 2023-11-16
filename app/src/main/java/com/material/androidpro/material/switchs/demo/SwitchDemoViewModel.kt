package com.material.androidpro.material.switchs.demo

import android.content.Context
import android.widget.CompoundButton
import android.widget.Toast
import com.material.sharedcode.utils.AppUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SwitchDemoViewModel(private val mContext: Context) {

    init {
        CoroutineScope(Dispatchers.IO).launch {
            // Task

            CoroutineScope(Dispatchers.Main).launch {

            }
        }
    }

    val changedListener = CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->
        if (isChecked) {
            AppUtils.showToast(mContext, "Checked", Toast.LENGTH_SHORT)
        } else {
            AppUtils.showToast(mContext, "Un-Checked", Toast.LENGTH_SHORT)
        }
    }

}