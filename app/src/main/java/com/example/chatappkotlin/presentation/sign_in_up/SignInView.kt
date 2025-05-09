package com.example.chatappkotlin.presentation.sign_in_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chatappkotlin.R
import com.example.chatappkotlin.navigation.Route
import com.example.chatappkotlin.presentation.sign_in_up.widget.CustomButtonSignInUp
import com.example.chatappkotlin.presentation.widget.CustomTextField
import com.example.chatappkotlin.ui.theme.CustomTypography

@Composable
fun SignInView(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.White) // 🌟 Thêm background màu trắng
            .fillMaxSize()
            .padding(start = 24.dp, top = 80.dp, end = 24.dp, bottom = 32.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.color_mail),
            contentDescription = "SVG Icon",
            modifier = Modifier.size(124.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = R.string.enjoy_awesome_chat),
            color = Color.Black,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight.W300
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(id = R.string.log_in),
            style = CustomTypography.SignInUpTitle
        )
        Spacer(modifier = Modifier.height(60.dp))
        CustomTextField(
            value = "",
            onValueChange = {},
            label = "Email",
            suffixIcon = R.drawable.mail_icon
        )
        Spacer(modifier = Modifier.height(40.dp))
        CustomTextField(
            value = "",
            onValueChange = {},
            label = stringResource(id = R.string.password),
            suffixIcon = R.drawable.key,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.forgot_password),
            style = CustomTypography.Text14W700,
            modifier = Modifier.align(alignment = Alignment.End)
        )
        Spacer(modifier = Modifier.height(48.dp))
        CustomButtonSignInUp(
            enable = true,
            onClick = { navController.navigate(Route.HomeScreen.route) },
            text = R.string.log_in
        )
        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            onClick = { navController.navigate(Route.RegisterScreen.route) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Row {
                Text(
                    text = stringResource(id = R.string.no_account),
                    style = CustomTypography.Text14W700,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(id = R.string.register_now),
                    style = CustomTypography.Text14W700,
                )
            }
        }


    }
}