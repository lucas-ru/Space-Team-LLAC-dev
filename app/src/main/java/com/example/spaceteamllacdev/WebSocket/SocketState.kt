package com.example.spaceteamllacdev.WebSocket

import com.example.spaceteamllacdev.Models.User

sealed class SocketState {
    object Loading : SocketState()
    data class SocketSuccessful(val Successmessage: String) : SocketState()
    data class Error(val errorMessage: String) :
        SocketState()
}