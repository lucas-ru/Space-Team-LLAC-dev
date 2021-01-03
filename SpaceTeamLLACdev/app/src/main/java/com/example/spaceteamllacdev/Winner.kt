package com.example.spaceteamllacdev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_winner.*

class Winner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_winner)

        button3.setOnClickListener{ buttonToLooser(layoutInflater.inflate(R.layout.activity_winner,null)) }

    }

    fun buttonToLooser(view: View){
        //Intent pour ouvrir l'activité suivante
        val intent = Intent(this, Looser::class.java)
        //Lancement de l'intent (changement d'écran)
        startActivity(intent)
    }
}