package com.example.spaceteamllacdev

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spaceteamllacdev.Models.EventGame
import com.example.spaceteamllacdev.Models.UIElement


class GameViewModel {

    val currentRoomName = MutableLiveData<String>()

    private val uiElementsForLevel = MutableLiveData<List<UIElement>>()
    fun getUIElementsForLevel(): LiveData<List<UIElement>> = uiElementsForLevel

    private val GameOverValues = MutableLiveData<EventGame.GameOver>()
    fun getGameOverValues(): LiveData<EventGame.GameOver> = GameOverValues

    private val currentLevel = MutableLiveData<Int>()
    private var userReady = false

    init{
        currentLevel.value = 1
    }
}