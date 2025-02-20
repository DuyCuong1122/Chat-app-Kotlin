package com.example.chatappkotlin.presentation.message

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import  dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val messageEvent: MessageEvent
):ViewModel() {
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
//        val friends = messageEvent(
//            searchQuery = _state.value.searchQuery,
//            sources = listOf("bbc-news", "abc-news", "al-jazeera-english")
//        ).cachedIn(viewModelScope)
//        _state.value = _state.value.copy(friends = friends)
    }

}