package com.example.chatappkotlin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import com.example.chatappkotlin.R
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

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
        NavigationBar {
            navItemList.forEachIndexed { index, navItem ->
                NavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = {
                        selectedIndex = index
                    },
                    icon = {
                        BadgedBox(badge = {
                            if (navItem.badgeCount > 0) {
                                Badge {
                                    Text(text = navItem.badgeCount.toString())
                                }
                            }
                        }) {
                            Image(
                                painter = painterResource(id = navItem.icon),
                                contentDescription = navItem.label,
                                colorFilter = ColorFilter.tint(colorResource(id = R.color.primaryColor))
                            )
                        }
                    },
                    label = { Text(navItem.label) }
                )
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