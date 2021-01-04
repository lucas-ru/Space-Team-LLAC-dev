package com.example.spaceteamllacdev.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.spaceteamllacdev.R
import kotlinx.android.synthetic.main.activity_winner.button3
import timber.log.Timber

class Looser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_looser)
        Timber.i("OnCreate called")

        button3.setOnClickListener{ buttonToMainActivity(layoutInflater.inflate(R.layout.activity_winner,null)) }

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

    fun buttonToMainActivity(view: View){
        //Intent pour ouvrir l'activité suivante
        val intent = Intent(this, MainActivity::class.java)
        //Lancement de l'intent (changement d'écran)
        startActivity(intent)
    }

}