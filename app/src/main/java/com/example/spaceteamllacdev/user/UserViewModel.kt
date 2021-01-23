package com.example.spaceteamllacdev.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceteamllacdev.Models.User
import com.example.spaceteamllacdev.Models.UserPost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception

class UserViewModel(userRepository: UserRepository) : ViewModel() {

    val userRepo : UserRepository = userRepository


    init {

    }

    fun connectUser(username: String) {
        viewModelScope.launch {
            val userConnect = UserApi.UserService.findOneUser(username)
            userConnect?.let {
                if (it.isSuccessful) {
                    userRepo.loginUser(it.body())
                } else {
                    throw HttpException(it)
                }
            }
        }
    }

    fun addUser(userPosted: UserPost) {
        viewModelScope.launch {
            val userRegister = UserApi.UserService.addUser(userPosted)
            userRegister?.let {
                if (it.isSuccessful) {
                    userRepo.registerUser(it.body())
                } else {
                    throw HttpException(it)
                }
            }


        }
    }
}