package com.example.spaceteamllacdev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)


        //Bouton Login
        button.setOnClickListener{ buttonToWaitingRoom(layoutInflater.inflate(R.layout.activity_login,null)) }




    }

    fun buttonToWaitingRoom(view: View){
        //Intent pour ouvrir l'activité suivante
        val intent = Intent(this, WaitingRoom::class.java)
        //Lancement de l'intent (changement d'écran)
        startActivity(intent)
    }
}
