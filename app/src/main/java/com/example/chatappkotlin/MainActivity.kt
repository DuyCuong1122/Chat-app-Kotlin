package com.example.chatappkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientBackgroundWithSVG()
        }
    }
}

@Composable
fun GradientBackgroundWithSVG() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF4356B4), Color(0xFF3DCFCF)) // Màu gradient
                )
            ),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.mail), // SVG của bạn
            contentDescription = "SVG Icon",
            modifier = Modifier.size(100.dp) // Điều chỉnh kích thước theo nhu cầu
        )
    }
}
