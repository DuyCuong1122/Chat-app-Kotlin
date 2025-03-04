package com.example.chatappkotlin.presentation.message

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

import  dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor() : ViewModel() {
    private var _state = mutableStateOf(MessageState())
    val state: State<MessageState> = _state

    fun onEvent(event: MessageEvent) {
        when (event) {
            is MessageEvent.UpdateSearchQuery -> {
                _state.value = _state.value.copy(searchQuery = event.searchQuery)
            }
            is MessageEvent.SearchFriend -> {
                searchFriend()
            }
        }
    }

    private fun searchFriend() {
        // Xử lý tìm kiếm bạn bè ở đây
    }
}
