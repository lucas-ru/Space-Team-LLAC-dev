package com.example.spaceteamllacdev

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spaceteamllacdev.Models.*
import com.example.spaceteamllacdev.WebSocket.EchoWebSocketListener
import com.example.spaceteamllacdev.WebSocket.SocketState
import okhttp3.*
import okio.IOException


class GameViewModel {

    val currentRoomName = MutableLiveData<String>()



    private val uiElementsForLevel = MutableLiveData<List<UIElement>>()
    fun getUIElementsForLevel(): LiveData<List<UIElement>> = uiElementsForLevel

    private val GameOverValues = MutableLiveData<EventGame.GameOver>()
    fun getGameOverValues(): LiveData<EventGame.GameOver> = GameOverValues

    private val currentLevel = MutableLiveData<Int>()
    private var userReady = false

//    fun getSocketState(): LiveData<SocketState> = SocketState
    fun getCurrentLevel(): LiveData<Int> = currentLevel


    private var webSocket: WebSocket
    private val listener = EchoWebSocketListener()

    init{
        currentLevel.value = 1

        val client = OkHttpClient()
        val request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws/join/TESTLLAC/1").build()
        val ws = client.newWebSocket(request, listener)

        webSocket = ws
    }

    fun getGameState(): LiveData<EventGame> = listener.GameState


    fun setUserReady(isReady: Boolean){
        userReady = isReady
    }
}