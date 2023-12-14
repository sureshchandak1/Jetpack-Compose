package com.material.androidpro.material.bottomnav.compose.withNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    data object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Outlined.Home
    )

    data object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Outlined.Person
    )

    data object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Outlined.Settings
    )

}