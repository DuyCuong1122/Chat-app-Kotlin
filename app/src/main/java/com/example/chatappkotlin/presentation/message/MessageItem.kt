package com.example.chatappkotlin.presentation.message

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatappkotlin.R
import com.example.chatappkotlin.ui.theme.CustomTypography

@Preview
@Composable
fun PreviewMessageItem() {
    MessageItem()
}

@Composable
fun MessageItem(
    badgeCount: Int = 0,
    onClick: () -> Unit = {},
    name: String = "Name",
    message: String = "Message",
    time: String = "12:00",
    isRead: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(color = Color.White).padding(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Avatar",
                modifier = Modifier.size(58.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = name,
                            style = CustomTypography.Text16W800,
                            color = Color.Black
                        )
                        Text(
                            text = message,
                            style = CustomTypography.Text14W700,
                            color = colorResource(id = if (isRead) R.color.f99Color else R.color.blackColor)
                        )
                    }
                    Text(
                        text = time,
                        style = CustomTypography.Text12W400,
                        color = colorResource(id = if (isRead) R.color.f99Color else R.color.blackColor)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                HorizontalDivider(color = colorResource(id = R.color.greyColor))
            }
        }
    }
}
