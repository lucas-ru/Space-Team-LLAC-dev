package com.example.spaceteamllacdev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_waiting_room.*

class WaitingRoom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_waiting_room)

        button4.setOnClickListener{ buttonToTableau(layoutInflater.inflate(R.layout.activity_waiting_room,null)) }

    }

    fun buttonToTableau(view: View){
        //Intent pour ouvrir l'activité suivante
        val intent = Intent(this, Tableau::class.java)
        //Lancement de l'intent (changement d'écran)
        startActivity(intent)
    }
}