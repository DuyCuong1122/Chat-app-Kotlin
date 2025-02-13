package com.example.chatappkotlin.presentation.widget
import androidx.compose.foundation.background
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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Color
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

    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
            onSearch(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp) // Đặt chiều cao hợp lý
            .clip(RoundedCornerShape(30.dp)) // Bo góc 30dp
            .background(colorResource(id = R.color.whiteColor)), // Màu nền cho đẹp
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
     )
}
