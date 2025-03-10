package com.example.chatappkotlin.presentation.chat.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatappkotlin.R
import com.example.chatappkotlin.data.models.MessageContent
import com.example.chatappkotlin.ui.theme.CustomTypography
import com.google.firebase.Timestamp

@Composable
fun LeftChatWidget(messageContent: MessageContent = MessageContent(), isLast: Boolean = false) {
    Row(modifier = Modifier.padding( end = 24.dp, bottom = 4.dp)) {
        if (isLast) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = null,
                modifier = Modifier.size(36.dp),
                contentScale = ContentScale.Crop
            )
        } else {
            Spacer(modifier = Modifier.width(36.dp))
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Box(
                Modifier
                    .widthIn(min = 90.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = Color(0xA0393939))
            ) {
                Text(
                    text = messageContent.content ?: "",
                    color = Color.Black,
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

}

@Preview
@Composable
fun PreviewLeftChatWidget() {
    LeftChatWidget(MessageContent(content = "Hello \n dasdasd"), isLast = true)
}