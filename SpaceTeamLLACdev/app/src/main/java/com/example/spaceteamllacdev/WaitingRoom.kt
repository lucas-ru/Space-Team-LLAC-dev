package com.example.spaceteamllacdev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_waiting_room.*
import timber.log.Timber

class WaitingRoom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_waiting_room)
        Timber.i("OnCreate called")

        button4.setOnClickListener{ buttonToTableau(layoutInflater.inflate(R.layout.activity_waiting_room,null)) }
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

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }

    fun buttonToTableau(view: View){
        //Intent pour ouvrir l'activité suivante
        val intent = Intent(this, Tableau::class.java)
        //Lancement de l'intent (changement d'écran)
        startActivity(intent)
    }
}