package com.example.chatappkotlin.presentation.sign_in_up

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chatappkotlin.R
import com.example.chatappkotlin.navigation.Route
import com.example.chatappkotlin.presentation.sign_in_up.widget.CustomButtonSignInUp
import com.example.chatappkotlin.presentation.widget.CustomCheckBox
import com.example.chatappkotlin.presentation.widget.CustomTextField
import com.example.chatappkotlin.ui.theme.CustomTypography
import androidx.hilt.navigation.compose.hiltViewModel

//@Preview
//@Composable
//fun PreviewSignUpView() {
//    SignUpView()
//}

@Composable

fun SignUpView(navController: NavController) {
    val  context = LocalContext.current
    val authViewModel = hiltViewModel<AuthViewModel>()
    // 🏷 Trạng thái của form
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var agreeToTerms by remember { mutableStateOf(false) }

    // 🛑 Trạng thái lỗi
    var usernameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    val registerState by authViewModel.registerState.collectAsState()

    // Kiểm tra lỗi ngay khi giá trị thay đổi

    LaunchedEffect(username, email, password) {
        usernameError = username.isBlank()
        emailError = !email.matches(Regex("^[A-Za-z0-9+_.-]+@(.+)$"))
        passwordError = password.length < 6
    }

    val isFormValid = !usernameError && !emailError && !passwordError && agreeToTerms

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp)
    ) {

        // Nút Back
        BackButton(onBackClick = navController::popBackStack)
        Spacer(modifier = Modifier.height(48.dp))

        // Tiêu đề
        Text(
            text = stringResource(id = R.string.register),
            style = CustomTypography.SignInUpTitle
        )
        Spacer(modifier = Modifier.height(60.dp))
        // Form Đăng Ký
        FormSignUp(
            username = username,
            onUsernameChange = { username = it },
            usernameError = usernameError,
            email = email,
            onEmailChange = { email = it },
            emailError = emailError,
            password = password,
            onPasswordChange = { password = it },
            passwordError = passwordError
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Đồng ý Điều khoản & Chính sách
        PoliciesAndTerm(
            enableButton = agreeToTerms,
            onCheckedChange = { agreeToTerms = it }
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Nút Đăng Ký
        CustomButtonSignInUp(
            text = R.string.register,
            onClick = {
                authViewModel.registerUser(context,username, email, password);
                println("registerState: $registerState")
            },
            enable = isFormValid
        )

        Spacer(modifier = Modifier.weight(1f))

        // Chuyển hướng Đăng Nhập
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = stringResource(id = R.string.already_have_an_account),
                style = CustomTypography.Text14W700
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = stringResource(id = R.string.log_in_now),
                style = CustomTypography.Text14W700,
                modifier = Modifier.clickable {
                    navController.navigate(Route.LoginScreen.route)
                }
            )
        }
    }
}

@Composable
fun FormSignUp(
    username: String,
    onUsernameChange: (String) -> Unit,
    usernameError: Boolean,
    email: String,
    onEmailChange: (String) -> Unit,
    emailError: Boolean,
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordError: Boolean
) {
    // Trường nhập tên người dùng
    CustomTextField(
        value = username,
        onValueChange = onUsernameChange,
        label = "Tên người dùng",
        isError = usernameError,
        errorMessage = "Tên không được bỏ trống",
        suffixIcon = R.drawable.ic_person
    )
    Spacer(modifier = Modifier.height(16.dp))

    // Trường nhập Email
    CustomTextField(
        value = email,
        onValueChange = onEmailChange,
        label = "Email",
        keyboardType = KeyboardType.Email,
        isError = emailError,
        errorMessage = "Email không hợp lệ",
        suffixIcon = R.drawable.mail_icon
    )
    Spacer(modifier = Modifier.height(16.dp))

    // Trường nhập mật khẩu
    CustomTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = "Mật khẩu",
        keyboardType = KeyboardType.Password,
        isError = passwordError,
        errorMessage = "Mật khẩu ít nhất 6 ký tự",
        suffixIcon = R.drawable.key
    )
}

@Composable
fun BackButton(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable { onBackClick() }
            .padding(0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "Back",
            tint = colorResource(id = R.color.primaryColor),
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun PoliciesAndTerm(enableButton: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
    ) {
        CustomCheckBox(
            checked = enableButton,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(id = R.string.i_agree_to),
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.W500
            )
        )
        Text(
            text = stringResource(id = R.string.policies),
            style = CustomTypography.Text14W700
        )
        Text(
            text = stringResource(id = R.string.and),
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.W500
            )
        )
        Text(
            text = stringResource(id = R.string.terms),
            style = CustomTypography.Text14W700
        )


    }
}
