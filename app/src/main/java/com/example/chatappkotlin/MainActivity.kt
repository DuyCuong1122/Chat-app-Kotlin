package com.example.chatappkotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.chatappkotlin.presentation.NextActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SplashScreen {
                startActivity(Intent(this, NextActivity::class.java))
                finish() // Kết thúc SplashScreen để tránh quay lại
            }
        }
    }
}

