package com.example.chatappkotlin.presentation.message

sealed class MessageEvent {
    data class UpdateSearchQuery(val searchQuery: String) : MessageEvent()

    data object SearchFriend : MessageEvent()
}