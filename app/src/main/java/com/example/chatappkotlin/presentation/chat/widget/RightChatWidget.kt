package com.example.chatappkotlin.presentation.chat.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatappkotlin.R
import com.example.chatappkotlin.data.models.MessageContent
import com.example.chatappkotlin.ui.theme.CustomTypography

@Composable
fun RightChatWidget(messageContent: MessageContent = MessageContent(), isLast: Boolean = false) {
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp, start = 72.dp)
    ) {
        Box(
            Modifier
                .widthIn(min = 90.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(color = colorResource(id = R.color.primaryColor))
        ) {
            Text(
                text = messageContent.content ?: "",
                color = Color.White,
                style = CustomTypography.Text18W500,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        if (isLast) {
            Text(
                text = "Today",
                color = colorResource(id = R.color.f99Color),
                style = CustomTypography.Text12W400,

                )
        }
    }

}

@Preview
@Composable
fun PreviewRightChatWidget() {
    RightChatWidget(MessageContent(content = "Hello"), true)
}