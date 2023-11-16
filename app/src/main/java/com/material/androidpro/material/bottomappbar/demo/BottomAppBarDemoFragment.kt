package com.material.androidpro.material.bottomappbar.demo

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
import com.material.androidpro.databinding.FragmentBottomAppBarDemoBinding
import com.material.sharedcode.utils.AppUtils

class BottomAppBarDemoFragment : Fragment(), ProfileCallback {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding : FragmentBottomAppBarDemoBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_bottom_app_bar_demo, container, false)

        ProfileSetup(requireContext(), binding.recyclerView, this)

        binding.bottomAppBar.setNavigationOnClickListener(object : View.OnClickListener {

            override fun onClick(view: View?) {

            }

        })

        binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    // Handle search icon press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }

        return binding.root
    }

    override fun itemClick(image: Drawable?, name: String?) {
        AppUtils.showToast(context, name, Toast.LENGTH_SHORT)
    }

}