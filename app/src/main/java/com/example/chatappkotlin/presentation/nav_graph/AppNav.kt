package com.example.chatappkotlin.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatappkotlin.SplashScreen
import com.example.chatappkotlin.presentation.HomeView
import com.example.chatappkotlin.presentation.sign_in_up.AuthViewModel
import com.example.chatappkotlin.presentation.sign_in_up.SignInView
import com.example.chatappkotlin.presentation.sign_in_up.SignUpView

@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.SplashScreen.route) {
        // Màn hình Splash
        composable(Route.SplashScreen.route) { SplashScreen(navController) }

        // Màn hình Đăng nhập / Đăng ký
        composable(Route.LoginScreen.route) {
            SignInView(navController)
        }
        composable(Route.RegisterScreen.route) {
            SignUpView(navController)
        }

        // Màn hình chính
        composable(Route.HomeScreen.route) { HomeView(navController) }

        // Các màn hình khác (có thể kích hoạt khi cần)
//        composable(Route.ProfileScreen.route) { ProfileScreen(navController) }
//        composable(Route.ChatScreen.route) { ChatScreen(navController) }
//        composable(Route.FriendsScreen.route) { FriendsScreen(navController) }
    }
}