package com.example.chatappkotlin.presentation.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatappkotlin.R

// Checkbox tròn
@Preview
@Composable
fun PreviewCustomCheckBox() {
    CustomCheckBox(checked = true, onCheckedChange = {})
}


@Composable
fun CustomCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .size(24.dp) // Kích thước của Checkbox
            .clip(CircleShape) // Làm tròn
            .background(if (checked) colorResource(id = R.color.primaryColor) else Color.White)
            .border(2.dp, colorResource(id = R.color.primaryColor), CircleShape)
            .clickable { onCheckedChange(!checked) },
        // Toggle khi click
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Icons.Default.Check, // Icon checkmark
                contentDescription = "Checked",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}