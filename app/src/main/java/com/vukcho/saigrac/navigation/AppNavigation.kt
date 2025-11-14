package com.vukcho.saigrac.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
        startDestination = "route",
        modifier = modifier.padding(innerPadding),
    ) {
        composable(
            route = "route",
        ) {
            Text(
                text = "Hello world!!",
                modifier = modifier,
            )
        }
    }
}
