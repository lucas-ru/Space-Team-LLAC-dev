package com.example.spaceteamllacdev.WebSocket

import androidx.lifecycle.MutableLiveData
import com.example.spaceteamllacdev.models.EventGame
import com.example.spaceteamllacdev.models.PolymorphicAdapter.eventGameParser
import com.example.spaceteamllacdev.models.UIElement
import com.example.spaceteamllacdev.models.User
import okhttp3.*

class EchoWebSocketListener : WebSocketListener() {
    var gameState = MutableLiveData<EventGame>()
    private var webSocket: WebSocket? = null


    override fun onOpen(webSocket: WebSocket, response: Response) {

        println("Socket open")

        //webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        when(eventGameParser.fromJson(text)!!::class.java) {
            EventGame.WaitingForPlayer::class.java -> {
                val webSocketState = eventGameParser.fromJson(text) as EventGame.WaitingForPlayer
                updateWebSocketState(webSocketState)
            }
            EventGame.GameOver::class.java -> {
                val webSocketState = eventGameParser.fromJson(text) as EventGame.GameOver
                updateWebSocketState(webSocketState)
            }
            EventGame.GameStarted::class.java -> {
                val webSocketState = eventGameParser.fromJson(text) as EventGame.GameStarted
                updateWebSocketState(webSocketState)
            }
            EventGame.NextAction::class.java -> {
                val webSocketState = eventGameParser.fromJson(text) as EventGame.NextAction
                updateWebSocketState(webSocketState)
            }
            EventGame.NextLevel::class.java -> {
                val webSocketState = eventGameParser.fromJson(text) as EventGame.NextLevel
                updateWebSocketState(webSocketState)
            }
        }
    }

//    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
//        println("Receiving bytes : " + bytes.hex())
//    }
//
//    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
//        webSocket.close(NORMAL_CLOSURE_STATUS, null)
//        println("Closing : $code / $reason")
//    }
//
//    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
//        println("Error : " + t.message)
//    }

    companion object {
        private const val NORMAL_CLOSURE_STATUS = 4000
    }

    fun OnLaunch(user: User?){
        val client = OkHttpClient()
        val request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws/join/TESTLLAC/${user?.id}").build()

        webSocket = client.newWebSocket(request, this)
        println(webSocket)
    }

    fun SendPlayerReady(){
        webSocket?.send(eventGameParser.toJson(
                EventGame.Ready(true)
        ))
    }

    fun SendPlayerUnready(){
        webSocket?.send(eventGameParser.toJson(
            EventGame.Ready(false)
        ))
    }

    fun SendPlayerAction(uiElement: UIElement){
        webSocket?.send(eventGameParser.toJson(
            EventGame.PlayerAction(uiElement)
        ))
    }

    private fun updateWebSocketState(event: EventGame){
        println(event)
        gameState.postValue(event)
    }

}