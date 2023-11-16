package com.material.androidpro.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.material.androidpro.R;
import com.material.androidpro.base.BaseActivity;
import com.material.androidpro.databinding.ActivityDashboardBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DashboardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDashboardBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_dashboard);
        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {

            }
        });
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setFallbackOnNavigateUpListener(new AppBarConfiguration.OnNavigateUpListener() {
                    @Override
                    public boolean onNavigateUp() {
                        return false;
                    }
                })
                .setDrawerLayout(binding.drawerLayout)
                .build();
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);

        //addFragment(DashboardFragment.newInstance());
    }

    @Override
    public Fragment getCurrentFragment() {
        /*FragmentManager manager = getSupportFragmentManager();
        return manager.findFragmentById(R.id.fragmentContainer);*/
        return null;
    }
}