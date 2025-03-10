package com.example.chatappkotlin.data.models

import com.google.firebase.Timestamp

data class MessageContent(
    val id: String? = null,
    val uid: String? = null,
    val content: String? = null,
    val timestamp: Timestamp? = null
)
