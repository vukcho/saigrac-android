package com.vukcho.saigrac.navigation.destinations

import androidx.navigation.NamedNavArgument

sealed interface Destination {
    val route: String
}

fun buildBaseRoute(
    routeUniquePrefix: String,
    pathArguments: List<NamedNavArgument>,
): String =
    buildDynamicRoute(
        routeUniquePrefix = routeUniquePrefix,
        pathArguments = pathArguments.map { "{${it.name}}" },
    )

fun buildDynamicRoute(
    routeUniquePrefix: String,
    pathArguments: List<String>,
): String =
    buildString {
        append(routeUniquePrefix)
        pathArguments.forEach { pathArgument ->
            append("/$pathArgument")
        }
    }
