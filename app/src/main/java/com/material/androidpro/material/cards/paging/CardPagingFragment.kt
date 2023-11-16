package com.material.androidpro.material.cards.paging

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.material.androidpro.R
import com.material.androidpro.common.profile.ProfileCallback
import com.material.androidpro.databinding.FragmentCardPagingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardPagingFragment : Fragment(), ProfileCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentCardPagingBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_card_paging, container, false)

        val viewModel = ViewModelProvider(this).get(CardPagingViewModel::class.java)

        val adapter = ProfilePagingAdapter(requireContext(), this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

        viewModel.profileList.observe(viewLifecycleOwner, Observer {
            adapter.submitData(lifecycle, it)
        })

        return binding.root
    }

    override fun itemClick(image: Drawable?, name: String?) {

    }

}