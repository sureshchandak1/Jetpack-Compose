package com.material.androidpro.material.bottomsheet.fullscreen

import android.app.Dialog
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.common.profile.list.ProfileListCallback
import com.material.androidpro.common.profile.list.ProfileListSetup
import com.material.androidpro.databinding.FragmentBottomSheetFullScreenBinding
import com.material.androidpro.databinding.FullScreenBottomSheetBinding
import com.material.androidpro.material.bottomsheet.demo.BottomSheetDemoViewModel
import com.material.sharedcode.utils.AppUtils
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFullScreenFragment : Fragment(), ProfileListCallback {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentBottomSheetFullScreenBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_bottom_sheet_full_screen, container, false)

        ProfileListSetup(context!!, binding.recyclerView, this)

        return binding.root
    }

    override fun itemClick(image: Drawable?, name: String?) {
        val bottomSheet = FullScreenBottomSheet(image, name)
        bottomSheet.show(parentFragmentManager, "FullScreenBottomSheet")
    }

    companion object {

        class FullScreenBottomSheet(private val image: Drawable?, private val name: String?) : BottomSheetDialogFragment() {

            private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
            private lateinit var bi: FullScreenBottomSheetBinding

            override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
                val bottomSheet = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

                val view = View.inflate(context, R.layout.full_screen_bottom_sheet, null)
                bi = DataBindingUtil.bind(view)!!
                bottomSheet.setContentView(view)

                val viewModel = BottomSheetDemoViewModel(image!!, name!!)
                bi.vm = viewModel

                bottomSheetBehavior = BottomSheetBehavior.from(view.parent as View)

                //setting Peek at the 16:9 ratio keyline of its parent.
                bottomSheetBehavior.peekHeight = BottomSheetBehavior.PEEK_HEIGHT_AUTO

                //setting max height of bottom sheet
                bi.extraSpace.setMinimumHeight((Resources.getSystem().displayMetrics.heightPixels) / 2)

                bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        if (BottomSheetBehavior.STATE_EXPANDED == newState) {
                            showView(bi.appBarLayout, getActionBarSize())
                            hideAppBar(bi.profileLayout)

                        }
                        if (BottomSheetBehavior.STATE_COLLAPSED == newState) {
                            hideAppBar(bi.appBarLayout)
                            showView(bi.profileLayout, getActionBarSize())
                        }

                        if (BottomSheetBehavior.STATE_HIDDEN == newState) {
                            dismiss()
                        }
                    }

                    override fun onSlide(bottomSheet: View, slideOffset: Float) {

                    }

                })

                bi.cancelBtn.setOnClickListener(View.OnClickListener { dismiss() })

                bi.editBtn.setOnClickListener(View.OnClickListener {
                    AppUtils.showToast(context, "Edit button clicked", Toast.LENGTH_SHORT)
                })

                bi.moreBtn.setOnClickListener(View.OnClickListener {
                    AppUtils.showToast(context, "More button clicked", Toast.LENGTH_SHORT)
                })

                hideAppBar(bi.appBarLayout)

                return bottomSheet

            }

            override fun onStart() {
                super.onStart()
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }

            private fun hideAppBar(view: View) {
                val params = view.layoutParams
                params.height = 0
                view.layoutParams = params
            }

            private fun showView(view: View, size: Int) {
                val params = view.layoutParams
                params.height = size
                view.layoutParams = params
            }

            private fun getActionBarSize(): Int {
                val array =
                    context!!.theme.obtainStyledAttributes(intArrayOf(android.R.attr.actionBarSize))
                return array.getDimension(0, 0f).toInt()
            }

        }

    }

}