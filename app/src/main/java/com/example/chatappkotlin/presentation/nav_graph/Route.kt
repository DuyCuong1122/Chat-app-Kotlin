package com.example.chatappkotlin.presentation.nav_graph

import androidx.navigation.NamedNavArgument

sealed class Route(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object SplashScreen : Route(route = "splashScreen")
    data object LoginScreen : Route(route = "loginScreen")
    data object HomeScreen : Route(route = "homeScreen")
    data object ProfileScreen : Route(route = "profileScreen")
    data object ChatScreen : Route(route = "chatScreen")
    data object RegisterScreen : Route(route = "registerScreen")
    data object FriendsScreen : Route(route = "friendsScreen")

}