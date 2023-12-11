package com.material.androidpro.compose.ui.navigation

sealed class Screen(val route: String) {
    data object MainScreen: Screen("main_screen")
    data object DetailScreen: Screen("detail_screen")

    fun withArgs(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}