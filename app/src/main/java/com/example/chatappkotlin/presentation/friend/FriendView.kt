package com.example.chatappkotlin.presentation.friend

import android.icu.text.CaseMap.Upper
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatappkotlin.R
import com.example.chatappkotlin.presentation.widget.CustomSearchBar
import com.example.chatappkotlin.ui.theme.CustomTypography

@Preview
@Composable
fun PreviewFriendView() {
    FriendView()
}

@Composable
fun FriendView() {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    var selectedTabIndex by remember { mutableIntStateOf(0) } // Trạng thái tab

    val tabs = listOf(
        stringResource(id = R.string.friends),
        stringResource(id = R.string.all),
        stringResource(id = R.string.request)
    ) // Danh sách tab


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
                        text = stringResource(id = R.string.friends),
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
                            painter = painterResource(id = R.drawable.ic_add_friend),
                            contentDescription = "Search",
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.primaryColor)),
                        )
                    }
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
            Column {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = Color.White,

                    ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            unselectedContentColor = colorResource(id = R.color.f99Color), // Màu xám khi chưa chọn
                            selectedContentColor = colorResource(id = R.color.primaryColor), // Màu khi được chọn
                        ) {
                            Text(
                                text = title.uppercase(),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W800,
                                modifier = Modifier.padding(12.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

                // Nội dung theo từng Tab
                when (selectedTabIndex) {
                    0 -> FriendList() // Danh sách tất cả bạn bè
                    1 -> AllFriends() // Danh sách bạn bè yêu thích
                    2 -> FriendRequest() // Gợi ý bạn bè
                }
            }
        }
    }
}

@Composable
fun FriendList() {
    Column {
        Text(
            text = stringResource(id = R.string.list_friends),
            style = CustomTypography.Text14W800,
            color = colorResource(id = R.color.f99Color),
            modifier = Modifier.padding(start = 12.dp)
        )

    }
}

@Composable
fun AllFriends() {
    Column {
        Text(
            text = stringResource(id = R.string.friends),
            style = CustomTypography.Text14W800,
            color = colorResource(id = R.color.f99Color),
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Composable
fun FriendRequest() {
    Column {
        Text(
            text = stringResource(id = R.string.request),
            style = CustomTypography.Text14W800,
            color = colorResource(id = R.color.f99Color),
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}
