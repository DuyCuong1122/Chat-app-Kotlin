package com.example.chatappkotlin.presentation.sign_in_up

import User
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> get() = _authState

    fun signInMethod(email: String, password: String) {
    }

    fun signUpMethod(email: String, password: String, username: String) {
        if (email.isEmpty() || password.length < 6 || username.isEmpty()) {
            _authState.value = AuthState.Error("Vui lòng nhập đầy đủ thông tin!")
            return
        }

        _authState.value = AuthState.Loading

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = task.result?.user?.uid ?: ""
                    saveUserToFirestore(userId, email, username)
                } else {
                    _authState.value = AuthState.Error(task.exception?.message ?: "Đăng ký thất bại!")
                }
            }
    }

    private fun saveUserToFirestore(userId: String, email: String, username: String) {
        val user = User(id = userId, email = email, username = username)

        firestore.collection("users").document(userId)
            .set(user)
            .addOnSuccessListener {
                _authState.value = AuthState.Success
            }
            .addOnFailureListener { e ->
                _authState.value = AuthState.Error("Lỗi khi lưu dữ liệu: ${e.message}")
            }
    }
}