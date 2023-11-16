package com.material.androidpro.material.slider.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.databinding.FragmentSliderDemoBinding
import com.material.sharedcode.utils.AppUtils
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider

class SliderDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentSliderDemoBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_slider_demo, container, false
        )

        binding.slider1.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {

            override fun onStartTrackingTouch(slider: Slider) {

            }

            override fun onStopTrackingTouch(slider: Slider) {
                AppUtils.showToast(requireContext(), "Value: " + slider.value, Toast.LENGTH_SHORT)
            }

        })

        binding.rangeSlider1.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {

            override fun onStartTrackingTouch(slider: RangeSlider) {

            }

            override fun onStopTrackingTouch(slider: RangeSlider) {
                AppUtils.showToast(requireContext(), "Value: " + slider.values.toString(), Toast.LENGTH_SHORT)
            }

        })

        binding.rangeSlider2.addOnChangeListener { rangeSlider, value, fromUser ->
            //AppUtils.showToast(requireContext(), "Value: $value", Toast.LENGTH_SHORT)
        }

        return binding.root
    }

}