package com.material.androidpro.material.toolbar.center

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.material.androidpro.R
import com.material.androidpro.common.profile.ProfileCallback
import com.material.androidpro.common.profile.ProfileSetup
import com.material.androidpro.databinding.FragmentToolbarCenterBinding
import com.material.sharedcode.utils.AppUtils

class ToolbarCenterFragment : Fragment(), ProfileCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentToolbarCenterBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_toolbar_center, container, false)

        ProfileSetup(requireContext(), binding.recyclerView, this)

        binding.topAppBar.setNavigationOnClickListener { view ->
            val navController = Navigation.findNavController(view)
            navController.popBackStack()
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    Toast.makeText(requireContext(), "Favorite", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(requireContext(), "More", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        return binding.root
    }

    override fun itemClick(image: Drawable?, name: String?) {
        AppUtils.showToast(requireContext(), name, Toast.LENGTH_SHORT)
    }

}