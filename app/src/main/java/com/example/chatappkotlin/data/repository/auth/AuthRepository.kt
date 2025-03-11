package com.example.chatappkotlin.data.repository.auth

import User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.piashcse.hilt_mvvm_compose_movie.utils.network.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepositoryInterface {

    override suspend fun registerUser(
        name: String,
        email: String,
        password: String
    ): Flow<DataState<User>> = flow {
        emit(DataState.Loading)
        try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val user = User(id = result.user?.uid ?: "", username = name, email = email)
            user.id?.let { firestore.collection("users").document(it).set(user).await() }
            emit(DataState.Success(user))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

    override suspend fun loginUser(email: String, password: String): Flow<DataState<User>> = flow {
        emit(DataState.Loading)
        try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val userDoc =
                firestore.collection("users").document(result.user?.uid ?: "").get().await()
            val user = userDoc.toObject(User::class.java) ?: throw Exception("User not found")
            emit(DataState.Success(user))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}