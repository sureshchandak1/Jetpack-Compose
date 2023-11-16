package com.material.androidpro.material.checkboxes.demo

import android.content.Context
import android.widget.CompoundButton
import android.widget.Toast
import com.material.androidpro.R
import com.material.sharedcode.utils.AppUtils

class CheckboxDemoViewModel internal constructor(private val mContext: Context) {

    val listener = CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->

        when (compoundButton.id) {
            R.id.checkbox1 -> if (isChecked) {
                AppUtils.showToast(mContext, "Checkbox 1 checked", Toast.LENGTH_SHORT)
            } else {
                AppUtils.showToast(mContext, "Checkbox 1 unchecked", Toast.LENGTH_SHORT)
            }
            R.id.checkbox2 -> if (isChecked) {
                AppUtils.showToast(mContext, "Checkbox 2 checked", Toast.LENGTH_SHORT)
            } else {
                AppUtils.showToast(mContext, "Checkbox 2 unchecked", Toast.LENGTH_SHORT)
            }
            R.id.checkbox3 -> if (isChecked) {
                AppUtils.showToast(mContext, "Checkbox 3 checked", Toast.LENGTH_SHORT)
            } else {
                AppUtils.showToast(mContext, "Checkbox 3 unchecked", Toast.LENGTH_SHORT)
            }
            R.id.checkbox4 -> if (isChecked) {
                AppUtils.showToast(mContext, "Checkbox 4 checked", Toast.LENGTH_SHORT)
            } else {
                AppUtils.showToast(mContext, "Checkbox 4 unchecked", Toast.LENGTH_SHORT)
            }
            R.id.checkbox5 -> if (isChecked) {
                AppUtils.showToast(mContext, "Checkbox 5 checked", Toast.LENGTH_SHORT)
            } else {
                AppUtils.showToast(mContext, "Checkbox 5 unchecked", Toast.LENGTH_SHORT)
            }
        }
    }
}