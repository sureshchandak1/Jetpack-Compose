package com.material.androidpro.material.bottomnav.compose.withNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.material.androidpro.material.bottomnav.compose.withNavigation.screens.HomeScreen
import com.material.androidpro.material.bottomnav.compose.withNavigation.screens.ProfileScreen
import com.material.androidpro.material.bottomnav.compose.withNavigation.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }
}