package com.example.chatappkotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp  // ✅ Bắt buộc để Hilt hoạt động
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
