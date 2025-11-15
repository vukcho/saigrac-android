package com.vukcho.saigrac.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vukcho.saigrac.navigation.destinations.HomeDestination
import com.vukcho.saigrac.ui.camera.CameraScreen
import com.vukcho.saigrac.ui.home.HomeScreen
import com.vukcho.saigrac.ui.saigracViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    navigationManager: NavigationManager,
    innerPadding: PaddingValues,
    modifier: Modifier,
) {
    NavigationObserver(navController = navController, navigationManager = navigationManager)

    NavHost(
        navController = navController,
        startDestination = HomeDestination.Home.route,
        modifier = modifier.padding(innerPadding),
    ) {
        composable(
            route = HomeDestination.Home.route,
        ) {
            HomeScreen(viewModel = saigracViewModel())
        }

        composable(
            route = HomeDestination.Camera.route,
            arguments = HomeDestination.Camera.arguments,
        ) {
            CameraScreen(viewModel = saigracViewModel())
        }
    }
}
