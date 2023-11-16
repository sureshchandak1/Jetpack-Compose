package com.material.androidpro.material.dialogs.alert

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.common.profile.ProfileCallback
import com.material.androidpro.common.profile.ProfileSetup
import com.material.androidpro.databinding.FragmentAlertDialogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AlertDialogFragment : Fragment(), ProfileCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentAlertDialogBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_alert_dialog, container, false)

        ProfileSetup(context!!, binding.recyclerView, this)

        showAlertDialog(ContextCompat.getDrawable(context!!, R.drawable.profile_1), "Aadhavi")

        return binding.root
    }

    private fun showAlertDialog(image: Drawable?, name: String?) {
        MaterialAlertDialogBuilder(context!!)
            .setTitle(name)
            .setMessage(getString(R.string.dummy_des))
            .setIcon(image)
            .setNeutralButton(getString(R.string.cancel)) { dialog, which ->
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.decline)) { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton(getString(R.string.accept)) { dialog, which ->
                dialog.dismiss()
            }
            .show()
    }

    override fun itemClick(image: Drawable?, name: String?) {
        showAlertDialog(image, name)
    }

}