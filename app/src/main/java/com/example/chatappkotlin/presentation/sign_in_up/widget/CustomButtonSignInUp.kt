package com.example.chatappkotlin.presentation.sign_in_up.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.chatappkotlin.R

@Composable
fun CustomButtonSignInUp(enable: Boolean, onClick: () -> Unit, text: Int) {
    Button(
        onClick = onClick,
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.primaryColor)
        ),
        enabled = enable,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        // 🌟 Đổi màu button

    ) {
        Text(text = stringResource(id = text))
    }
}