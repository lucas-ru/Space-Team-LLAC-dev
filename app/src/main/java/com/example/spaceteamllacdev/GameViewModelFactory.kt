package com.example.spaceteamllacdev

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spaceteamllacdev.WebSocket.EchoWebSocketListener
import com.example.spaceteamllacdev.user.UserRepository

class GameViewModelFactory(private val repository: UserRepository, private val webSocket: EchoWebSocketListener) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(repository, webSocket) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}