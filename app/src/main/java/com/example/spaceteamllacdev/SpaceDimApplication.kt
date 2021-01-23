package com.example.spaceteamllacdev

import android.app.Application
import com.example.spaceteamllacdev.user.UserRepository
import timber.log.Timber

class SpaceDimApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())


    }

    companion object {
        val userRepository = UserRepository()
    }
}