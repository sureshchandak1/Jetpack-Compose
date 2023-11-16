package com.material.androidpro.material.progress.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.databinding.FragmentProgressDemoBinding

class ProgressDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProgressDemoBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_progress_demo, container, false)

        binding.linearProgressIndicator.isIndeterminate = true
        binding.circularProgressIndicator.isIndeterminate = true
        binding.circularProgressIndicator1.isIndeterminate = true

        binding.switchDe.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.linearProgressIndicator.isIndeterminate = false
                binding.circularProgressIndicator.isIndeterminate = false
                binding.circularProgressIndicator1.isIndeterminate = false
                binding.progressValue.setText("10")
                binding.linearProgressIndicator.progress = 10
                binding.circularProgressIndicator.progress = 10
                binding.circularProgressIndicator1.progress = 10
            } else {
                binding.linearProgressIndicator.isIndeterminate = true
                binding.circularProgressIndicator.isIndeterminate = true
                binding.circularProgressIndicator1.isIndeterminate = true
                binding.progressValue.setText("")
                binding.linearProgressIndicator.progress = 0
                binding.circularProgressIndicator.progress = 0
                binding.circularProgressIndicator1.progress = 0
            }
        }

        binding.progressButton.setOnClickListener {
            val progressValue: String = binding.progressValue.text.toString()
            if (!binding.linearProgressIndicator.isIndeterminate) {
                binding.linearProgressIndicator.progress = progressValue.toInt()
            }
            if (!binding.circularProgressIndicator.isIndeterminate) {
                binding.circularProgressIndicator.progress = progressValue.toInt()
            }
            if (!binding.circularProgressIndicator1.isIndeterminate) {
                binding.circularProgressIndicator1.progress = progressValue.toInt()
            }
        }

        binding.show.setOnClickListener {
            binding.linearProgressIndicator.show()
            binding.circularProgressIndicator.show()
            binding.circularProgressIndicator1.show()
        }

        binding.hide.setOnClickListener {
            binding.linearProgressIndicator.hide()
            binding.circularProgressIndicator.hide()
            binding.circularProgressIndicator1.hide()
        }

        return binding.root
    }


}