package com.example.chatappkotlin.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.example.chatappkotlin.R

// Load font từ resources
val LatoBlack = FontFamily(Font(R.font.lato_black))
val LatoBold = FontFamily(Font(R.font.lato_bold))
val LatoRegular = FontFamily(Font(R.font.lato_regular))
val LatoLight = FontFamily(Font(R.font.lato_light))

object CustomTypography {
    val SignInUpTitle = TextStyle(
        fontFamily = LatoBlack,
        fontSize = 32.sp,
        color = Color(0xFF4356B4) // Màu primary
    )

    val Text30W700 = TextStyle(
        fontFamily = LatoBold,
        fontSize = 30.sp,
        color = Color(0xFF4356B4)
    )

    val Text22W700 = TextStyle(
        fontFamily = LatoBold,
        fontSize = 22.sp,
        color = Color(0xFF4356B4)
    )

    val Text18W500 = TextStyle(
        fontFamily = LatoRegular,
        fontSize = 18.sp,
        color = Color(0xFF4356B4)
    )

    val Text16W800 = TextStyle(
        fontFamily = LatoBlack,
        fontSize = 16.sp,
        color = Color(0xFF4356B4)
    )

    val Text14W700 = TextStyle(
        fontFamily = LatoBold,
        fontSize = 14.sp,
        color = Color(0xFF4356B4)
    )

    val Text14W800 = TextStyle(
        fontFamily = LatoBlack,
        fontSize = 14.sp,
        color = Color(0xFF4356B4)
    )

    val Text12W400 = TextStyle(
        fontFamily = LatoLight,
        fontSize = 12.sp,
        color = Color(0xFF4356B4)
    )
}
