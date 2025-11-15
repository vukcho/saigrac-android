package com.vukcho.saigrac.navigation.destinations

sealed class HomeDestination(
    override val route: String,
) : Destination {
    data object Home : HomeDestination(route = "home")
}
