package com.example.chatappkotlin.domain.models

import com.google.firebase.Timestamp

data class Request(
    val id: String? = null,
    val fromUId: String? = null,
    val toUId: String? = null,
    val fromName: String? = null,
    val toName: String? = null,
    val createdAt: Timestamp? = null
)
