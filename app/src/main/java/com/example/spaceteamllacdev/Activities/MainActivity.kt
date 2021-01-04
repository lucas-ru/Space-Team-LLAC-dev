package com.example.spaceteamllacdev.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import com.example.spaceteamllacdev.R
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)
        Timber.i("OnCreate called")

        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //val navController = navHostFragment.navController

        //Bouton Login
        button.setOnClickListener{ buttonToWaitingRoom(layoutInflater.inflate(R.layout.activity_login,null)) }




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

    fun buttonToWaitingRoom(view: View){
        //Intent pour ouvrir l'activité suivante
        val intent = Intent(this, WaitingRoom::class.java)
        //Lancement de l'intent (changement d'écran)
        startActivity(intent)
    }
}
