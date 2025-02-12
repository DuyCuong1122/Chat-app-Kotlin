//package com.example.chatappkotlin.presentation
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.sp
//import androidx.navigation.compose.rememberNavController
//
//
//// Định nghĩa các màn hình trong navigation
//sealed class Screen(val route: String, val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
//    object Home : Screen("home", "Home", Icons.Filled.Home)
//    object Chat : Screen("chat", "Chat", Icons.Filled.Message)
//    object Profile : Screen("profile", "Profile", Icons.Filled.Person)
//}
//
//@Composable
//fun MainScreen() {
//    val navController = rememberNavController()
//
//    Scaffold(
//        bottomBar = { BottomNavigationBar(navController = navController) }
//    ) { paddingValues ->
//        NavHost(
//            navController = navController,
//            startDestination = Screen.Home.route,
//            modifier = Modifier.padding(paddingValues)
//        ) {
//            composable(Screen.Home.route) { HomeScreen() }
//            composable(Screen.Chat.route) { ChatScreen() }
//            composable(Screen.Profile.route) { ProfileScreen() }
//        }
//    }
//}
//
//// Bottom Navigation Bar
//@Composable
//fun BottomNavigationBar(navController: NavController) {
//    val items = listOf(Screen.Home, Screen.Chat, Screen.Profile)
//
//    NavigationBar(
//        containerColor = Color.White,
//        contentColor = Color.Black
//    ) {
//        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
//        items.forEach { screen ->
//            NavigationBarItem(
//                icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
//                label = { Text(screen.title) },
//                selected = currentRoute == screen.route,
//                onClick = {
//                    navController.navigate(screen.route) {
//                        popUpTo(navController.graph.startDestinationId) { saveState = true }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }
//}
//
//// Màn hình Home
//@Composable
//fun HomeScreen() {
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        Text(text = "Home Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
//    }
//}
//
//// Màn hình Chat
//@Composable
//fun ChatScreen() {
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        Text(text = "Chat Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
//    }
//}
//
//// Màn hình Profile
//@Composable
//fun ProfileScreen() {
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        Text(text = "Profile Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
//    }
//}