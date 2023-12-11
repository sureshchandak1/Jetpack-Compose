package com.material.androidpro.compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.material.androidpro.compose.ui.navigation.detail.DetailScreen
import com.material.androidpro.compose.ui.navigation.main.MainScreen
import com.material.androidpro.utils.JsonKeys

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            /*
            *  Required Arguments = route/{name}/{age}
            *  Optional Arguments = route?name={name}&age={age}
            * */
            route = Screen.DetailScreen.route + "/{${JsonKeys.KEY_NAME}}",
            arguments = listOf(
                navArgument(JsonKeys.KEY_NAME) {
                    type = NavType.StringType
                    defaultValue = "John"
                    nullable = true
                }
            )
        ) { entry ->
            val name = entry.arguments?.getString(JsonKeys.KEY_NAME)
            DetailScreen(navController = navController, name = name)
        }
    }
}