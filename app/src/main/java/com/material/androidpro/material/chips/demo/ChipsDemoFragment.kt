package com.material.androidpro.material.chips.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.databinding.FragmentChipsDemoBinding

class ChipsDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentChipsDemoBinding>(inflater,
            R.layout.fragment_chips_demo, container, false)

        val viewModel = ChipsDemoViewModel(context!!)
        binding.vm = viewModel

        return binding.root
    }

}