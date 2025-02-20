package com.example.chatappkotlin.presentation.message

import com.example.chatappkotlin.domain.models.Message
import kotlinx.coroutines.flow.Flow

data class MessageState(
    val messages: Flow<List<Message>>? = null,
    val searchQuery: String = "",
    val isLoading: Boolean = false
)