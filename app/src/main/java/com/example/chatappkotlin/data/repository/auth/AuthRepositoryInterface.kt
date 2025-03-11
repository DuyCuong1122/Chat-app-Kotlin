package com.example.chatappkotlin.data.repository.auth

import User
import com.piashcse.hilt_mvvm_compose_movie.utils.network.DataState
import kotlinx.coroutines.flow.Flow

interface AuthRepositoryInterface {
    suspend fun registerUser(name: String, email: String, password: String): Flow<DataState<User>>
    suspend fun loginUser(email: String, password: String): Flow<DataState<User>>
}