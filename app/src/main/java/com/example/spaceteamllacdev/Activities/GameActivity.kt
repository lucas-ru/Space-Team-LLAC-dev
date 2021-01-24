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




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_game)

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

}
