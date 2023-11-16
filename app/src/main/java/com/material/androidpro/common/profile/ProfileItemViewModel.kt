package com.material.androidpro.common.profile

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.databinding.ObservableField
import com.material.androidpro.adapters.ViewModel

class ProfileItemViewModel(
    context: Context?, image: Drawable?,
    name: String, shortDes: String?, private val mCallback: ProfileCallback
) : ViewModel {

    @JvmField
    val mImage = ObservableField<Drawable>()

    @JvmField
    val mName = ObservableField<String>()

    init {
        mImage.set(image)
        mName.set(name)
    }

    fun itemClick(view: View?) {
        mCallback.itemClick(mImage.get(), mName.get())
    }

    override fun close() {}

}