package com.example.chatappkotlin.domain.models

import com.google.firebase.Timestamp

data class MessageContent(
    val id: String? = null,
    val uid: String? = null,
    val content: String? = null,
    val type: String ?  = null,
    val timestamp: Timestamp? = null
)
