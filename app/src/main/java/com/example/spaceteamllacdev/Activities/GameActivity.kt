package com.example.spaceteamllacdev.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.spaceteamllacdev.Models.EventGame
import com.example.spaceteamllacdev.Models.PolymorphicAdapter
import com.example.spaceteamllacdev.Models.PolymorphicAdapter.eventGameParser
import com.example.spaceteamllacdev.R
import com.example.spaceteamllacdev.WebSocket.EchoWebSocketListener
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*
import okio.ByteString
import timber.log.Timber

class GameActivity : AppCompatActivity() {

    private val client = OkHttpClient()
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    //private val jsonAdapter = moshi.adapter(EventGame::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_game)


        start()
        Timber.i("onCreate Called")

    }

    override fun onStart() {
        super.onStart()

        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }

    private fun start() {

        val request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws/join/TESTLLAC/1").build()
        val listener = EchoWebSocketListener()
        val ws = client.newWebSocket(request, listener)


        ws.send(eventGameParser.toJson(
            EventGame.Ready(true)
        ))
    }

    /*private class EchoWebSocketListener : WebSocketListener() {

        override fun onOpen(webSocket: WebSocket, response: Response) {

            println("Socket open")

            //webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !")
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            println("Receiving : $text")

        }

        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            println("Receiving bytes : " + bytes.hex())
        }

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            webSocket.close(NORMAL_CLOSURE_STATUS, null)
            println("Closing : $code / $reason")
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            println("Error : " + t.message)
        }

        companion object {
            private const val NORMAL_CLOSURE_STATUS = 4000
        }
    }*/
}

data class EventStart (
    val type: String,
    val value: Boolean
)