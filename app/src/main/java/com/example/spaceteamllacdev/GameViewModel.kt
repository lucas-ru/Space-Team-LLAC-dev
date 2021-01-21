package com.example.spaceteamllacdev

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spaceteamllacdev.Models.*
import com.example.spaceteamllacdev.Models.PolymorphicAdapter.eventGameParser
import com.example.spaceteamllacdev.WebSocket.EchoWebSocketListener
import com.example.spaceteamllacdev.WebSocket.SocketState
import okhttp3.*
import okio.IOException


class GameViewModel : ViewModel() {

    val currentRoomName = MutableLiveData<String>()

    private val _isReady = MutableLiveData<Boolean>()
    val isReady: LiveData<Boolean>
        get() = _isReady

    private val uiElementsForLevel = MutableLiveData<List<UIElement>>()
    fun getUIElementsForLevel(): LiveData<List<UIElement>> = uiElementsForLevel

    private val GameOverValues = MutableLiveData<EventGame.GameOver>()
    fun getGameOverValues(): LiveData<EventGame.GameOver> = GameOverValues

    private val currentLevel = MutableLiveData<Int>()
    private var userReady = false

//    fun getSocketState(): LiveData<SocketState> = SocketState
    fun getCurrentLevel(): LiveData<Int> = currentLevel

    val listener = EchoWebSocketListener()


    init{
        currentLevel.value = 1
    }

    fun onLaunch() = listener.OnLaunch()


    val getGameState: LiveData<EventGame> = listener.gameState

//    private fun updateGameState(eventGame: EventGame) = when(eventGame){
//        is EventGame.WaitingForPlayer -> {
//            val action = 1
//        }
//    }


    fun setUserReady() = listener.SendPlayerReady()

}