package com.material.androidpro.material.bottomsheet.demo

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
import com.material.androidpro.databinding.DemoBottomSheetBinding
import com.material.androidpro.databinding.FragmentBottomSheetDemoBinding
import com.material.sharedcode.utils.AppUtils
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDemoFragment : Fragment(), ProfileCallback {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentBottomSheetDemoBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_bottom_sheet_demo, container, false)

        ProfileSetup(context!!, binding.recyclerView, this)

        return binding.root
    }

    override fun itemClick(image: Drawable?, name: String?) {
        val sheet = DemoBottomSheet(image, name)
        sheet.show(parentFragmentManager, "DemoBottomSheet")
    }

    companion object {

        class DemoBottomSheet(private val image: Drawable?,
                                      private val name: String?) : BottomSheetDialogFragment() {

            override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
                val binding: DemoBottomSheetBinding = DataBindingUtil.inflate(inflater,
                    R.layout.demo_bottom_sheet, container, false)

                val viewModel = BottomSheetDemoViewModel(image!!, name!!)
                binding.vm = viewModel

                binding.detailButton.setOnClickListener {
                    AppUtils.showToast(context, "Details click", Toast.LENGTH_SHORT)
                }

                binding.closeButton.setOnClickListener { dismiss() }

                return binding.root
            }

        }

    }

}