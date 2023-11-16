package com.material.androidpro.material.bottomsheet.demo

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField

class BottomSheetDemoViewModel(image: Drawable, name: String) {

    val mImage = ObservableField<Drawable>()
    val mName = ObservableField<String>()

    init {
        mImage.set(image)
        mName.set(name)
    }

}