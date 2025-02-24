package com.example.chatappkotlin.presentation.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatappkotlin.R
import com.example.chatappkotlin.domain.models.MessageContent
import com.example.chatappkotlin.presentation.chat.widget.LeftChatWidget
import com.example.chatappkotlin.ui.theme.CustomTypography

@Preview
@Composable
fun PreviewMessageView() {
    ChatView()
}

@Composable
fun ChatView(name: String = "Cuong", time: String = "Today") {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .background(color = colorResource(id = R.color.f6Color))
            .fillMaxSize()
    ) {
        Box {
            Row(
                Modifier.padding(start = 8.dp, top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .size(50.dp)

                )
                Text(
                    text = name,
                    style = CustomTypography.Text18W500,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )

            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .offset(y = screenHeight * 0.15f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(color = Color.White)
                .padding(top = 18.dp, start = 12.dp, end = 12.dp, bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f) // Chiếm hết phần trống, chừa chỗ cho input
                        .fillMaxWidth(),
                    reverseLayout = true // Cuộn từ dưới lên
                ) {
                    items(10) { index -> // Giả lập danh sách tin nhắn
                        LeftChatWidget(MessageContent(content = "hehe $index"), isLast = index == 0)
                    }
                }
                MessageInputField() // Luôn hiển thị phía dưới
            }
        }


    }
}

@Composable
fun MessageInputField() {
    var message by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(shape = CircleShape) // Đảm bảo là hình tròn
                .background(color = colorResource(id = R.color.f6Color))
                .wrapContentSize(Alignment.Center) // Căn giữa chính xác
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_album),
                contentDescription = "Thêm ảnh",
                modifier = Modifier.background(color = colorResource(id = R.color.f99Color))
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            modifier = Modifier
                .clip(RoundedCornerShape(size = 30.dp))
                .weight(1f)
                .height(50.dp),
            placeholder = { Text("Nhập tin nhắn...") }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_send),
            contentDescription = "Gửi",
            modifier = Modifier
                .size(40.dp)
                .padding(8.dp)
        )
    }
}
