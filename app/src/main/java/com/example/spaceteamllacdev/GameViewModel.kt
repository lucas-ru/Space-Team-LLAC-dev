package com.example.spaceteamllacdev

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spaceteamllacdev.models.*
import com.example.spaceteamllacdev.WebSocket.EchoWebSocketListener
import com.example.spaceteamllacdev.user.UserRepository


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

    private val gameOverValues = MutableLiveData<EventGame.GameOver>()
    fun getGameOverValues(): LiveData<EventGame.GameOver> = gameOverValues

    private val _Name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _Name

    private val currentLevel = MutableLiveData<Int>()
    private var userReady = false

    fun getCurrentLevel(): LiveData<Int> = currentLevel

//    val listener = EchoWebSocketListener()


    init{
        currentLevel.value = 1
    }



    fun onLaunch() = webSocket.OnLaunch(name.value, userRepo.currentUser.value)


    fun setUserReady() {
        _GameState.value = EventType.READY
    }

    fun setUserUnready() {
//        _GameState.value = EventType.READY
    }

    fun setUiElementForLevel(uiElements : List<UIElement>) {
        uiElementsForLevel.value = uiElements
    }

    fun setGameOverValue(gameOverVal : EventGame.GameOver) {
        gameOverValues.value = gameOverVal
    }

    fun givename(nameroom: String) {
        _Name.value = nameroom
        println(name.value)
    }
}