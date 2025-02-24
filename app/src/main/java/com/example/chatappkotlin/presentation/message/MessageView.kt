package com.example.chatappkotlin.presentation.message

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatappkotlin.R
import com.example.chatappkotlin.presentation.message.widget.MessageItem
import com.example.chatappkotlin.presentation.widget.CustomSearchBar
import com.example.chatappkotlin.ui.theme.CustomTypography

@Preview
@Composable
fun PreviewMessageView() {
    MessageView()
}

@Composable
fun MessageView() {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val scrollState = rememberScrollState()


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
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.message),
                        style = CustomTypography.Text30W700,
                        color = colorResource(id = R.color.whiteColor)
                    )
                    Box(
                        modifier = Modifier
                            .size(35.dp)
                            .clip(CircleShape)
                            .background(colorResource(id = R.color.whiteColor)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_new_chat),
                            contentDescription = "Search",
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.primaryColor)),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                CustomSearchBar(placeholderText = stringResource(id = R.string.search_message))
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
            Column(modifier = Modifier.padding(top = 4.dp, start = 12.dp, end = 12.dp)) {
                Text(
                    text = stringResource(id = R.string.message),
                    style = CustomTypography.Text18W500,
                    color = colorResource(id = R.color.f99Color)
                )
            }
        }
    }
}