package com.material.androidpro.material.dialogs.confirmation

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.common.profile.ProfileCallback
import com.material.androidpro.common.profile.ProfileSetup
import com.material.androidpro.databinding.FragmentConfirmationDialogBinding
import com.material.sharedcode.utils.AppUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ConfirmationDialogFragment : Fragment(), ProfileCallback {

    private var checkedItem = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentConfirmationDialogBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_confirmation_dialog, container, false
        )

        ProfileSetup(context!!, binding.recyclerView, this)

        showMultiChoiceAlertDialog(ContextCompat.getDrawable(context!!, R.drawable.profile_1), "Aadhavi")

        return binding.root
    }

    private fun showMultiChoiceAlertDialog(image: Drawable?, name: String?) {
        MaterialAlertDialogBuilder(context!!)
            .setTitle(name)
            .setIcon(image)
            .setSingleChoiceItems(
                items, checkedItem
            ) { dialog, which ->
                checkedItem = which
            }
            .setNeutralButton("") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("") { dialog, which ->
                dialog.dismiss()
                AppUtils.showToast(context, items[checkedItem], Toast.LENGTH_SHORT)
            }
            .setPositiveButtonIcon(ContextCompat.getDrawable(context!!, R.drawable.ic_done))
            .setNeutralButtonIcon(ContextCompat.getDrawable(context!!, R.drawable.ic_close))
            .show()
    }

    private val items = arrayOf(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
        "Item 6",
        "Item 7",
        "Item 8",
        "Item 9",
        "Item 10",
    )

    override fun itemClick(image: Drawable?, name: String?) {
        showMultiChoiceAlertDialog(image, name)
    }

}