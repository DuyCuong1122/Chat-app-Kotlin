package com.example.chatappkotlin.presentation.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatappkotlin.R

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: Boolean = false,
    errorMessage: String = "",
    suffixIcon: Int? = null // ✅ Fix lỗi thiếu giá trị mặc định
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = TextStyle(fontSize = 14.sp, color = Color.Gray),
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
            singleLine = true,
            isError = isError,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = if (isError) Color.Red else Color.Gray,
                focusedBorderColor = if (isError) Color.Red else colorResource(id = R.color.primaryColor)
            ),
            trailingIcon = {
                suffixIcon?.let {
                    Icon(
                        painter = painterResource(id = it),
                        contentDescription = "Suffix Icon",
                        modifier = Modifier.size(20.dp),
                        tint = colorResource(id = R.color.primaryColor)
                    )
                }
            }
        )

        if (isError) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCustomOutlinedTextField() {
    var text by remember { mutableStateOf("") }

    CustomTextField(
        value = text,
        onValueChange = { text = it },
        label = "Email",
        isError = text.isNotEmpty() && !text.contains("@"),
        errorMessage = "Email không hợp lệ!",
        suffixIcon = R.drawable.mail_icon
    )
}
