package com.material.androidpro.common.profile

import android.graphics.drawable.Drawable

interface ProfileCallback {
    fun itemClick(image: Drawable?, name: String?)
}