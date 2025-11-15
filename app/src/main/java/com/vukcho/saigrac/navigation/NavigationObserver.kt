package com.vukcho.saigrac.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController

@Composable
fun NavigationObserver(
    navController: NavHostController,
    navigationManager: NavigationManager,
) {
    LaunchedEffect(Unit) {
        navigationManager.navigationCommands.collect { command ->
            when (command) {
                is NavigationCommand.NavigateTo -> navController.navigate(command.destination.route)
                is NavigationCommand.NavigateBack -> navController.popBackStack()
            }
        }
    }
}
