package com.example.chatappkotlin.presentation.nav_graph

import androidx.navigation.NamedNavArgument

sealed class Route(val route: String) {
    data object SplashScreen : Route("splashScreen")
    data object LoginScreen : Route("loginScreen")
    data object RegisterScreen : Route("registerScreen")
    data object HomeScreen : Route("homeScreen")
    // Add other routes as needed
}