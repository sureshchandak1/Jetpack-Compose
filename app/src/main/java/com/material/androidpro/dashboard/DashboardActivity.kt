package com.material.androidpro.dashboard

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.material.androidpro.R
import com.material.androidpro.base.BaseActivity
import com.material.androidpro.databinding.ActivityDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDashboardBinding>(
            this,
            R.layout.activity_dashboard
        )
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayShowTitleEnabled(false)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        val navController = navHostFragment!!.navController
        navController.addOnDestinationChangedListener { navController, navDestination, bundle -> }

        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration.Builder(navController.graph)
            .setFallbackOnNavigateUpListener { false }
            .setDrawerLayout(binding.drawerLayout)
            .build()
        setupWithNavController(binding.toolbar, navController, appBarConfiguration)

        //addFragment(DashboardFragment.newInstance());
    }

}