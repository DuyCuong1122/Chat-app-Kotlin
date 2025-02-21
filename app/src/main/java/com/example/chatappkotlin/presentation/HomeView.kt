package com.example.chatappkotlin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import com.example.chatappkotlin.R
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatappkotlin.presentation.message.MessageView

@Preview
@Composable
fun PreviewHomeView() {
    HomeView(navController = rememberNavController())
}

@Composable
fun HomeView(navController: NavController) {

    val navItemList = listOf(
        NavItem(stringResource(id = R.string.message), R.drawable.ic_chat, 1),
        NavItem(stringResource(id = R.string.friends), R.drawable.ic_friends, 2),
        NavItem(stringResource(id = R.string.profile), R.drawable.ic_profile, 3),
    )

    var selectedIndex by remember { mutableIntStateOf(0) }
    val focusManager = LocalFocusManager.current // Quản lý focus


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .pointerInput(Unit){
                detectTapGestures(onTap = {
                    focusManager.clearFocus() // Xóa focus khi người dùng bấm vào màn hình
                })
            },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.f6Color))
            ) {
                NavigationBar(
                    modifier = Modifier
                        .padding(start = 12.dp, top = 12.dp, end = 12.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = Color.White),
                ) {
                    navItemList.forEachIndexed { index, navItem ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = {
                                selectedIndex = index
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (navItem.badgeCount > 0) {
                                            Badge {
                                                Text(text = navItem.badgeCount.toString())
                                            }
                                        }
                                    },
                                ) {
                                    Image(
                                        painter = painterResource(id = navItem.icon),
                                        contentDescription = navItem.label,
                                        colorFilter = ColorFilter.tint(
                                            colorResource(
                                                id = if (selectedIndex == index) R.color.primaryColor else R.color.greyColor
                                            )
                                        )
                                    )
                                }
                            },
                            label = {
                                Text(
                                    navItem.label, color = colorResource(
                                        id = if (selectedIndex == index) R.color.primaryColor else R.color.greyColor
                                    )
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(id = R.color.f6Color))
        ) {
            ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
        }
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    when (selectedIndex) {
        0 -> MessageView()
        1 -> MessageView()
        2 -> MessageView()
    }
}