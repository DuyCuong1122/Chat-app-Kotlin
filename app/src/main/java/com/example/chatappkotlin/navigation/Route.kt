package com.example.chatappkotlin.navigation

sealed class Route(val route: String) {
    data object SplashScreen : Route("splash_screen")
    data object LoginScreen : Route("login_screen")
    data object RegisterScreen : Route("register_screen")
    data object HomeScreen : Route("home_screen")
}
