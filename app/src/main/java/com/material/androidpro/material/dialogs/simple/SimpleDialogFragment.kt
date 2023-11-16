package com.material.androidpro.material.dialogs.simple

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.common.profile.ProfileCallback
import com.material.androidpro.common.profile.ProfileSetup
import com.material.androidpro.databinding.FragmentSimpleDialogBinding
import com.material.sharedcode.utils.AppUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SimpleDialogFragment : Fragment(), ProfileCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentSimpleDialogBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_simple_dialog, container, false
        )

        ProfileSetup(context!!, binding.recyclerView, this)

        showAlertDialog()

        return binding.root
    }

    private fun showAlertDialog() {
        MaterialAlertDialogBuilder(context!!)
            .setTitle("Aadhavi")
            .setItems(items) { dialog, which ->
                dialog.dismiss()
                AppUtils.showToast(context, items[which], Toast.LENGTH_SHORT)
            }
            .show()
    }

    private fun showMultiChoiceAlertDialog(image: Drawable?, name: String?) {
        MaterialAlertDialogBuilder(context!!)
            .setTitle(name)
            .setIcon(image)
            .setMultiChoiceItems(
                items,
                itemsBooleans
            ) { dialog, position, checked ->
                itemsBooleans[position] = checked
            }
            .setNeutralButton(getString(R.string.cancel)) { dialog, which ->
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.decline)) { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton(getString(R.string.accept)) { dialog, which ->
                dialog.dismiss()
                val builder = StringBuilder()
                itemsBooleans.forEachIndexed { index, b ->
                    if (b) {
                        builder.append(items[index])
                        builder.append(", ")
                    }
                }
                AppUtils.showToast(context, builder.toString(), Toast.LENGTH_SHORT)
            }
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

    private val itemsBooleans =
        booleanArrayOf(false, false, false, false, false, false, false, false, false, false)

    override fun itemClick(image: Drawable?, name: String?) {
        showMultiChoiceAlertDialog(image, name)
    }

}