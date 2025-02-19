package com.example.chatappkotlin.presentation.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.chatappkotlin.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatappkotlin.ui.theme.CustomTypography

@Preview
@Composable
fun PreviewSearchBar() {
    CustomSearchBar()
}


@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    placeholderText: String = "Tìm kiếm...",
    onSearch: (String) -> Unit = {}
) {
    var searchText by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current // Quản lý focus


    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .weight(1f) // Chiếm phần lớn không gian, giữ khoảng trống cho nút "Hủy"
                .height(50.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(colorResource(id = R.color.whiteColor))
                .clickable { isFocused = true }
        ) {
            TextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                    onSearch(it)
                    isFocused = true
                },
                modifier = modifier
                    .fillMaxWidth()
                    , // Màu nền cho đẹp
                placeholder = {
                    Text(
                        placeholderText,
                        color = colorResource(id = R.color.f99Color),
                        style = CustomTypography.Text18W500
                    )
                },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = colorResource(id = R.color.primaryColor)
                    )
                },
                trailingIcon = {
                    if (searchText.isNotEmpty()) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_delete),
                            contentDescription = "Delete Icon",
                            modifier = Modifier.clickable { searchText = "" }
                        )
                    }
                }
            )
        }
        if (isFocused) {
            Text(
                text = stringResource(id = R.string.cancel),
                color = colorResource(id = R.color.whiteColor),
                style = CustomTypography.Text18W500,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {
                        searchText = ""
                        isFocused = false
                        focusManager.clearFocus()
                    }
            )
        }
    }
}
