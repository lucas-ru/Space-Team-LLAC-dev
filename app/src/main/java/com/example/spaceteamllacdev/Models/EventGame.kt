package com.example.spaceteamllacdev.Models

enum class EventType() {
    GAME_STARTED(), GAME_OVER(), ERROR(), READY(), NEXT_ACTION(),
    NEXT_LEVEL(), WAITING_FOR_PLAYER(), PLAYER_ACTION()
}

sealed class EventGame(val type: EventType) {
    data class NextAction(val action: Action) : EventGame(EventType.NEXT_ACTION)
    data class GameStarted(val uiElementList: List<UIElement>): EventGame(EventType.GAME_STARTED)
    data class GameOver(val score: Int, val win: Boolean, val level: Int): EventGame(EventType.GAME_OVER)
    data class NextLevel(val uiElementList: List<UIElement>, val level: Int) : EventGame(EventType.NEXT_LEVEL)
    data class WaitingForPlayer(val userList: List<User>) : EventGame(EventType.WAITING_FOR_PLAYER)
    data class Error(val message: String) : EventGame(EventType.ERROR)
    data class Ready(val value: Boolean) : EventGame(EventType.READY)
    data class PlayerAction(val uiElement: UIElement): EventGame(EventType.PLAYER_ACTION)
}