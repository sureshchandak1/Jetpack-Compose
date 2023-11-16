package com.material.androidpro.material.bottomnav.demo

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.common.profile.ProfileCallback
import com.material.androidpro.common.profile.ProfileSetup
import com.material.androidpro.databinding.FragmentBottomNavDemoBinding
import com.material.sharedcode.utils.AppUtils
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavDemoFragment : Fragment(), ProfileCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentBottomNavDemoBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_bottom_nav_demo, container, false)

        ProfileSetup(requireContext(), binding.recyclerView, this)

        val badge: BadgeDrawable = binding.bottomNavigation.getOrCreateBadge(R.id.favorite)
        badge.isVisible = true
        badge.number = 8

        binding.bottomNavigation.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId) {
                    R.id.home -> {

                        return true
                    }
                    R.id.news -> {

                        return true
                    }
                    R.id.music -> {

                        return true
                    }
                    R.id.favorite -> {
                        badge.number = 0
                        badge.isVisible = false
                        return true
                    }
                    R.id.settings -> {

                        return true
                    }
                    else -> return false
                }
            }

        })

        return binding.root
    }

    override fun itemClick(image: Drawable?, name: String?) {
        AppUtils.showToast(requireContext(), name, Toast.LENGTH_SHORT)
    }

}