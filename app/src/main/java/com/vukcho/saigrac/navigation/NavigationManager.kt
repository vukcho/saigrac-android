package com.vukcho.saigrac.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigationManager {
    private val _navigationCommands = MutableSharedFlow<NavigationCommand>()
    val navigationCommands = _navigationCommands.asSharedFlow()

    suspend fun navigateTo(destination: Destination) {
        _navigationCommands.emit(NavigationCommand.NavigateTo(destination))
    }

    suspend fun navigateBack() {
        _navigationCommands.emit(NavigationCommand.NavigateBack)
    }
}

sealed class NavigationCommand {
    data class NavigateTo(
        val destination: Destination,
    ) : NavigationCommand()

    data object NavigateBack : NavigationCommand()
}
