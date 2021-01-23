package com.example.spaceteamllacdev.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spaceteamllacdev.Models.User

class UserRepository {

    private val _CurrentUser = MutableLiveData<User>()

    val currentUser: LiveData<User>
        get() = _CurrentUser

    fun loginUser(user: User?){
        _CurrentUser.postValue(user)
    }

    fun registerUser(user: User?){
        _CurrentUser.postValue(user)
    }

}