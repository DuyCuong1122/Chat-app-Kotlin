package com.example.chatappkotlin.presentation.create_message.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatappkotlin.R
import com.example.chatappkotlin.presentation.widget.CustomCheckBox
import com.example.chatappkotlin.ui.theme.CustomTypography

@Preview
@Composable
fun FriendSelectedItemPreview() {
    FriendSelectedItem()
}

@Composable
fun FriendSelectedItem(
    onClick: () -> Unit = {},
    name: String = "Name",
    isSelected: Boolean = false
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(72.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .clickable { onClick() } // Thêm sự kiện nhấn vào
                .padding(top = 18.dp, start = 12.dp, end = 12.dp)
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Avatar",
                    modifier = Modifier.size(35.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 8.dp)
                    ) {
                        Text(
                            text = name,
                            style = CustomTypography.Text16W800,
                            color = Color.Black
                        )
                        CustomCheckBox(checked = true, onCheckedChange = {})
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    HorizontalDivider(color = colorResource(id = R.color.greyColor))
                }
            }
        }
    }
}