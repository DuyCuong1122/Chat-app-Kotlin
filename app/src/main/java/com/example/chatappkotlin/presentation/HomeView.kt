package com.example.chatappkotlin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import com.example.chatappkotlin.R
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PreviewHomeView() {
    HomeView()
}

@Composable
fun HomeView() {

    val navItemList = listOf<NavItem>(
        NavItem(stringResource(id = R.string.message), R.drawable.ic_chat, 1),
        NavItem(stringResource(id = R.string.friends), R.drawable.ic_friends, 2),
        NavItem(stringResource(id = R.string.profile), R.drawable.ic_profile, 3),
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.blackColor))
        ) {
            NavigationBar(
                modifier = Modifier
                    .padding(12.dp)
                    .clip(RoundedCornerShape(12.dp))
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

    }) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
//    when( selectedIndex)
//    {
//        0 -> SignUpView {  }
//        1 -> SignUpView {  }
//        2 -> SignUpView {  }
//
//    }
}