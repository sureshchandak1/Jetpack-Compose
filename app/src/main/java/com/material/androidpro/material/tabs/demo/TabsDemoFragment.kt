package com.material.androidpro.material.tabs.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.databinding.FragmentTabsDemoBinding


class TabsDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentTabsDemoBinding>(inflater,
            R.layout.fragment_tabs_demo, container, false)
        val viewModel = TabsDemoViewModel(requireContext(), binding.tabLayout)
        binding.vm = viewModel

        return binding.root
    }

}