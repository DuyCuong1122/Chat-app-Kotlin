package com.example.chatappkotlin.data.repository

import User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.piashcse.hilt_mvvm_compose_movie.utils.network.DataState
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) {
    suspend fun registerUser(name: String, email: String, password: String): DataState<User> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val user = User(id = result.user?.uid ?: "", username = name, email = email)

            user.id?.let { firestore.collection("users").document(it).set(user).await() }

            DataState.Success(user)
        } catch (e: Exception) {
            DataState.Error(e)
        }
    }

    suspend fun loginUser(email: String, password: String): DataState<User> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val userDoc = firestore.collection("users").document(result.user?.uid ?: "").get().await()
            val user = userDoc.toObject(User::class.java) ?: throw Exception("User not found")

            DataState.Success(user)
        } catch (e: Exception) {
            DataState.Error(e)
        }
    }
}