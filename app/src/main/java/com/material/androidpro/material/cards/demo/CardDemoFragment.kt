package com.material.androidpro.material.cards.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.databinding.FragmentCardDemoBinding

class CardDemoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentCardDemoBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_card_demo, container, false)

        val viewModel = CardDemoViewModel()
        binding.vm = viewModel

        binding.outlineCheckedCard.setOnLongClickListener {
            binding.outlineCheckedCard.isChecked = !binding.outlineCheckedCard.isChecked
            true
        }

        binding.filledCheckedCard.setOnLongClickListener {
            binding.filledCheckedCard.isChecked = !binding.filledCheckedCard.isChecked
            true
        }

        binding.elevatedCheckedCard.setOnLongClickListener {
            binding.elevatedCheckedCard.isChecked = !binding.elevatedCheckedCard.isChecked
            true
        }

        return binding.root
    }

}