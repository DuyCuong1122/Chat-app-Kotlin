package com.example.chatappkotlin
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chatappkotlin.presentation.nav_graph.Route
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    // Chạy hiệu ứng delay 3 giây trước khi chuyển màn hình
    LaunchedEffect(Unit) {
        delay(1000)
        val isLoggedIn = true // Kiểm tra trạng thái đăng nhập (thay bằng logic thực tế)

        if (isLoggedIn) {
            navController.navigate(Route.HomeScreen.route) {
                popUpTo(Route.SplashScreen.route) { inclusive = true }
            }
        } else {
            navController.navigate(Route.LoginScreen.route) {
                popUpTo(Route.SplashScreen.route) { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.primaryColor),
                        colorResource(id = R.color.secondaryColor)
                    ) // Màu gradient
                )
            ),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.mail), // SVG của bạn
                contentDescription = "SVG Icon",
                modifier = Modifier.size(100.dp) // Điều chỉnh kích thước theo nhu cầu
            )
            Row {
                Text(
                    text = "Awesome ",
                    color = Color.White,
                    style = androidx.compose.ui.text.TextStyle(fontSize = 40.sp, fontWeight = FontWeight.W900)
                )
                Text(
                    text = "Chat",
                    color = Color.White,
                    style = androidx.compose.ui.text.TextStyle(fontSize = 40.sp, fontWeight = FontWeight.W300)
                )
            }
        }
    }
}
