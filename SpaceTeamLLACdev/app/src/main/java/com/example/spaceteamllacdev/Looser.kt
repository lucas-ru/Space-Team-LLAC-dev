package com.example.spaceteamllacdev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_looser.*
import kotlinx.android.synthetic.main.activity_winner.*
import kotlinx.android.synthetic.main.activity_winner.button3

class Looser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_looser)

        button3.setOnClickListener{ buttonToMainActivity(layoutInflater.inflate(R.layout.activity_winner,null)) }

    }

    fun buttonToMainActivity(view: View){
        //Intent pour ouvrir l'activité suivante
        val intent = Intent(this, MainActivity::class.java)
        //Lancement de l'intent (changement d'écran)
        startActivity(intent)
    }

}