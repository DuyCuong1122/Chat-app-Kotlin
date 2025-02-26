package com.example.chatappkotlin.domain.models

import com.google.firebase.Timestamp
data class Message(
    val id: String? = null,
    val fromUId: String? = null,
    val toUId: String? = null,
    val lastMessage: String? = null,
    val lastTime: Timestamp? = null,
    val fromName: String? = null,
    val toName: String? = null,
    val unreadCount: Int? = 0,
    val lastSenderId: String? = null
)
