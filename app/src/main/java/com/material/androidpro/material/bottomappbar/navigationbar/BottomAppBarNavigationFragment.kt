package com.material.androidpro.material.bottomappbar.navigationbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.common.places.PlacesSetup
import com.material.androidpro.databinding.FragmentBottomAppBarNavigationBinding

class BottomAppBarNavigationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentBottomAppBarNavigationBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_bottom_app_bar_navigation, container, false)

        PlacesSetup(requireContext(), binding.recyclerView)

        binding.bottomNavigationView.background = null

        return binding.root
    }

}