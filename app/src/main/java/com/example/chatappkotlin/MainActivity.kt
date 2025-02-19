package com.example.chatappkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.chatappkotlin.presentation.nav_graph.AppNav

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ensure this is called before setContent
//        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            AppNav()
        }
    }
}