package com.material.androidpro.material.bottomsheet.modal

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.common.profile.list.ProfileListCallback
import com.material.androidpro.common.profile.list.ProfileListSetup
import com.material.androidpro.databinding.FragmentBottomSheetModalBinding
import com.material.androidpro.databinding.ModalBottomSheetBinding
import com.material.androidpro.material.bottomsheet.demo.BottomSheetDemoViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetModalFragment : Fragment(), ProfileListCallback {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentBottomSheetModalBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_bottom_sheet_modal, container, false
        )

        ProfileListSetup(context!!, binding.recyclerView, this)

        return binding.root
    }

    override fun itemClick(image: Drawable?, name: String?) {
        val sheet = ModalBottomSheet(image, name)
        sheet.show(parentFragmentManager, "ModalBottomSheet")
    }

    companion object {

        class ModalBottomSheet(
            private val image: Drawable?,
            private val name: String?
        ) : BottomSheetDialogFragment() {

            override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
                val binding: ModalBottomSheetBinding = DataBindingUtil.inflate(inflater,
                    R.layout.modal_bottom_sheet, container, false)

                val viewModel = BottomSheetDemoViewModel(image!!, name!!)
                binding.vm = viewModel

                return binding.root
            }

        }

    }
}