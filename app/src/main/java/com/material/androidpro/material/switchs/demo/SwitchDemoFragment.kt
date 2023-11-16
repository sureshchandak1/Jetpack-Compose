package com.material.androidpro.material.switchs.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.databinding.FragmentSwitchDemoBinding

class SwitchDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentSwitchDemoBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_switch_demo, container, false)
        val viewModel = SwitchDemoViewModel(requireContext())
        binding.vm = viewModel
        return binding.root
    }


}