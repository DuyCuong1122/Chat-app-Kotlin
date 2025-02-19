package com.example.chatappkotlin.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatappkotlin.SplashScreen
import com.example.chatappkotlin.presentation.HomeView
import com.example.chatappkotlin.presentation.sign_in_up.SignInView
import com.example.chatappkotlin.presentation.sign_in_up.SignUpView

@Composable
fun AppNav() {
    val nacController = rememberNavController()

    NavHost(navController = nacController, startDestination = Route.SplashScreen.route) {
        composable(route = Route.SplashScreen.route) {
            SplashScreen(nacController)
        }
        composable(route = Route.LoginScreen.route) {
            SignInView(nacController)
        }
        composable(route = Route.HomeScreen.route) {
            HomeView(nacController)
        }
//        composable(route = Route.ProfileScreen.route) {
//            ProfileScreen()
//        }
//        composable(route = Route.ChatScreen.route) {
//            ChatScreen()
//        }
        composable(route = Route.RegisterScreen.route) {
            SignUpView(nacController)
        }
//        composable(route = Route.FriendsScreen.route) {
//            FriendsScreen()
//        }
    }
}