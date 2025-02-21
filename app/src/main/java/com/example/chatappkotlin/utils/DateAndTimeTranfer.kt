package com.example.chatappkotlin.utils

import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateAndTimeTransfer {

    fun convertTimeStampToDateTime(time: Timestamp): String {
        val date: Date = time.toDate() // Chuyển Timestamp thành Date
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()) // Định dạng thời gian
        return formatter.format(date) // Chuyển thành chuỗi
    }
}
