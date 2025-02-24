package com.example.chatappkotlin.presentation.create_message

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatappkotlin.R
import com.example.chatappkotlin.presentation.create_message.widget.FriendSelectedItem
import com.example.chatappkotlin.presentation.widget.CustomCheckBox
import com.example.chatappkotlin.presentation.widget.CustomSearchBar
import com.example.chatappkotlin.ui.theme.CustomTypography

@Preview
@Composable
fun PreviewMessageView() {
    CreateMessageView()
}

@Composable
fun CreateMessageView() {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.28f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.primaryColor),
                            colorResource(id = R.color.secondaryColor)
                        ),// Màu gradient

                    )
                )
                .padding(12.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "Logo",
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.whiteColor)),
                    )
                    Text(
                        text = stringResource(id = R.string.create_message),
                        style = CustomTypography.Text18W500,
                        color = colorResource(id = R.color.whiteColor)
                    )
                    Text(
                        text = stringResource(id = R.string.cancel),
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W500),
                        color = colorResource(id = R.color.whiteColor)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                CustomSearchBar(placeholderText = stringResource(id = R.string.search_friends))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.82f)
                .offset(y = screenHeight * 0.18f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(color = Color.White)
                .padding(top = 18.dp)
        )
        {
            Column() {
                Text(
                    text = stringResource(id = R.string.list_friends),
                    style = CustomTypography.Text14W800,
                    color = colorResource(id = R.color.f99Color),
                    modifier = Modifier.padding(start = 12.dp)
                )
                LazyColumn {
                    items(10) {
                        FriendSelectedItem()
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(color = colorResource(id = R.color.f6Color))
                    .padding(12.dp)
                    .align(Alignment.BottomCenter),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LazyRow(
                        modifier = Modifier.weight(1f) // Chỉ LazyRow chiếm không gian còn lại
                    ) {
                        items(10) { SelectedAvatar() }
                    }

                    Box( // Box chứa icon luôn cố định ở cuối
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(color = colorResource(id = R.color.primaryColor))
                            .wrapContentSize(Alignment.Center)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_next),
                            contentDescription = "Next",
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.whiteColor)),
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun SelectedAvatar() {
    Row {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape) // Cắt thành hình tròn
                .background(colorResource(id = R.color.whiteColor)), // Để có nền trắng (tùy chọn)
            contentAlignment = Alignment.Center // Căn giữa nội dung bên trong
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(56.dp) // Đảm bảo ảnh vừa với Box
                    .clip(CircleShape), // Đảm bảo ảnh cũng bị cắt tròn
                contentScale = ContentScale.Crop // Cắt ảnh vừa với khung tròn
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
    }
}
