package com.material.androidpro.material.toolbar.collapsing.large

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.material.androidpro.R
import com.material.androidpro.common.places.PlacesSetup
import com.material.androidpro.databinding.FragmentCollapsingToolbarLargeBinding

class CollapsingToolbarLargeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentCollapsingToolbarLargeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_collapsing_toolbar_large, container, false)

        PlacesSetup(requireContext(), binding.recyclerView)

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

}