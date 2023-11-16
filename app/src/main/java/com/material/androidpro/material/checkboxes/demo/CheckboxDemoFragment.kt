package com.material.androidpro.material.checkboxes.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.databinding.FragmentCheckboxDemoBinding

class CheckboxDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentCheckboxDemoBinding>(inflater,
            R.layout.fragment_checkbox_demo, container, false)

        val viewModel = CheckboxDemoViewModel(context!!)
        binding.vm = viewModel

        return binding.root
    }

}