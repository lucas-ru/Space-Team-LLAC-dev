package com.example.spaceteamllacdev

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spaceteamllacdev.Models.*
import com.example.spaceteamllacdev.Models.PolymorphicAdapter.eventGameParser
import com.example.spaceteamllacdev.WebSocket.EchoWebSocketListener
import com.example.spaceteamllacdev.WebSocket.SocketState
import com.example.spaceteamllacdev.user.UserRepository
import okhttp3.*
import okio.IOException


class GameViewModel(userRepository: UserRepository,val webSocket: EchoWebSocketListener) : ViewModel() {

    val currentRoomName = MutableLiveData<String>()

    val userRepo : UserRepository = userRepository

    val getGameState: LiveData<EventGame> = webSocket.gameState


//    fun getGameState(): LiveData<EventGame> = webSocket.gameState

//    val webSocket : EchoWebSocketListener = webSocket

    private val _GameState = MutableLiveData<EventType>()
    val GameState: LiveData<EventType>
        get() = _GameState

    private val uiElementsForLevel = MutableLiveData<List<UIElement>>()
    fun getUIElementsForLevel(): LiveData<List<UIElement>> = uiElementsForLevel

    private val GameOverValues = MutableLiveData<EventGame.GameOver>()
    fun getGameOverValues(): LiveData<EventGame.GameOver> = GameOverValues

    private val currentLevel = MutableLiveData<Int>()
    private var userReady = false

    fun getCurrentLevel(): LiveData<Int> = currentLevel

//    val listener = EchoWebSocketListener()


    init{
        println("zebi")
        currentLevel.value = 1
    }



    fun onLaunch() = webSocket.OnLaunch(userRepo.currentUser.value)


    fun setUserReady() {
        _GameState.value = EventType.READY
    }
}