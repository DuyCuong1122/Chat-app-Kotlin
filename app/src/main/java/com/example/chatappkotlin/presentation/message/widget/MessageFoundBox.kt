package com.example.chatappkotlin.presentation.message.widget

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatappkotlin.R
import com.example.chatappkotlin.ui.theme.CustomTypography

@Preview
@Composable
fun MessageFoundBoxPreview() {
    MessageFoundBox()
}

@Composable
fun MessageFoundBox(
    onClick: () -> Unit = {},
    name: String = "Name",
    messageCount: Int = 0
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(92.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .clickable { onClick() } // Thêm sự kiện nhấn vào
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Avatar",
                    modifier = Modifier.size(58.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = name,
                        style = CustomTypography.Text16W800,
                        color = Color.Black
                    )
                    Text(
                        text = messageCount.toString() + " " + stringResource(id = R.string.suitable_message),
                        style = CustomTypography.Text14W700,
                        color = colorResource(id = R.color.f99Color)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    HorizontalDivider(color = colorResource(id = R.color.greyColor))
                }
            }
        }
    }
}