package com.example.spaceteamllacdev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tableau.*

class Tableau : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_tableau)

        btnEnd.setOnClickListener{ buttonToWinner(layoutInflater.inflate(R.layout.activity_tableau,null)) }
    }

    fun buttonToWinner(view: View){
        //Intent pour ouvrir l'activité suivante
        val intent = Intent(this, Winner::class.java)
        //Lancement de l'intent (changement d'écran)
        startActivity(intent)
    }
}