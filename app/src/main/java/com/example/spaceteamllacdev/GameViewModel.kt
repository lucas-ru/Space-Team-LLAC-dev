package com.example.spaceteamllacdev

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spaceteamllacdev.Models.EventGame
import com.example.spaceteamllacdev.Models.UIElement
import okhttp3.*
import okio.IOException


class GameViewModel {

    private val client = OkHttpClient()

    fun runApp() {
        val request = Request.Builder()
            .url("ws://spacedim.async-agency.com:8081/ws")
            .build()


        /*client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")


                }
            }
        })*/
    }

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