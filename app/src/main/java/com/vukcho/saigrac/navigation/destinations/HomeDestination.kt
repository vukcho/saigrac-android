package com.vukcho.saigrac.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class HomeDestination(
    override val route: String,
) : Destination {
    data object Home : HomeDestination(route = "home")

    data class Camera(
        val counter: Int,
    ) : HomeDestination(
        route = buildDynamicRoute(
            routeUniquePrefix = ROUTE_PREFIX,
            pathArguments = listOf(counter.toString()),
        )
    ) {
        companion object {
            private const val ROUTE_PREFIX = "camera_screen"

            const val COUNTER_ARG = "counter"

            val arguments: List<NamedNavArgument>
                get() = listOf(
                    navArgument(COUNTER_ARG) { type = NavType.StringType },
                )

            private val CAMERA_SCREEN_ROUTE = buildBaseRoute(
                routeUniquePrefix = ROUTE_PREFIX,
                pathArguments = arguments,
            )

            val route = CAMERA_SCREEN_ROUTE
        }
    }
}
