package com.example.spaceteamllacdev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Winner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_winner)
    }
}