package com.example.spaceteamllacdev.WebSocket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spaceteamllacdev.Models.EventGame
import com.example.spaceteamllacdev.Models.PolymorphicAdapter.eventGameParser
import com.example.spaceteamllacdev.Models.UIElement
import com.example.spaceteamllacdev.Models.User
import okhttp3.*
import okio.ByteString
import timber.log.Timber

class EchoWebSocketListener : WebSocketListener() {
    val _gameState = MutableLiveData<EventGame>()
    val gameState: LiveData<EventGame>
        get() = _gameState
    private var webSocket: WebSocket? = null


    override fun onOpen(webSocket: WebSocket, response: Response) {

        println("Socket open")

        //webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        _gameState.postValue(eventGameParser.fromJson(text))
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

    fun OnLaunch(user: User){
        val client = OkHttpClient()
        val request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws/join/TESTLLAC/${user.id}").build()

        println(request)
        webSocket = client.newWebSocket(request, this)
        println("On se co oklm")
    }

    fun SendPlayerReady(){
        println("Mtn on est pret NORMALEMENT")
        webSocket?.send(eventGameParser.toJson(
                EventGame.Ready(true)
        ))
    }

}