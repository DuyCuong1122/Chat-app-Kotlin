package com.example.chatappkotlin.presentation.sign_in_up

import User
import android.content.Context
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.example.chatappkotlin.R

import com.example.chatappkotlin.data.repository.AuthRepository

import com.piashcse.hilt_mvvm_compose_movie.utils.network.DataState

import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch

import java.util.regex.Pattern

import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(

    private val authRepository: AuthRepository

) : ViewModel() {

    private val _registerState = MutableStateFlow<DataState<User>?>(null)

    val registerState = _registerState.asStateFlow()

    private val _loginState = MutableStateFlow<DataState<User>?>(null)

    val loginState = _loginState.asStateFlow()

    private val emailPattern = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    )
    private fun validateInput(email: String, password: String, name: String? = null): Int? {
        if (name != null && name.isBlank()) return R.string.empty_name
        if (!emailPattern.matcher(email).matches()) return R.string.invalid_email_format
        if (password.length < 6) return R.string.invalid_password_format
        return null
    }

    fun registerUser(context : Context , name: String, email: String, password: String) {
        validateInput(email, password, name)?.let {
            _registerState.value = DataState.Error(Exception(context.getString(it)))
            return
        }

        viewModelScope.launch {
            _registerState.value = DataState.Loading
            _registerState.value = authRepository.registerUser(name, email, password)
        }

    }

    fun loginUser(context : Context ,email: String, password: String) {

        validateInput(email, password)?.let {
            _loginState.value = DataState.Error(Exception(context.getString(it)))
            return
        }

        viewModelScope.launch {

            _loginState.value = DataState.Loading

            _loginState.value = authRepository.loginUser(email, password)

        }

    }

}

