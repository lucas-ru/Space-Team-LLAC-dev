package com.example.spaceteamllacdev.WebSocket

sealed class SocketState {
    object Loading : SocketState()
    data class SocketSuccessful(val Successmessage: String) : SocketState()
    data class Error(val errorMessage: String) :
        SocketState()
    object Inactive : SocketState()
}