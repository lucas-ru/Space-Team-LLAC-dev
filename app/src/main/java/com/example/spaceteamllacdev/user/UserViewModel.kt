package com.example.spaceteamllacdev.user

import androidx.lifecycle.*
import com.example.spaceteamllacdev.models.UserPost
import kotlinx.coroutines.launch
import retrofit2.HttpException


class UserViewModel(userRepository: UserRepository) : ViewModel() {

    val userRepo : UserRepository = userRepository


    private val _tryConnection = MutableLiveData<Boolean>()
    val tryConnection : LiveData<Boolean>
        get() = _tryConnection


    private val _errorConnection = MutableLiveData<String>()
    val errorConnection : LiveData<String>
        get() = _errorConnection

    init {
        _tryConnection.value = false
    }

    fun connectUser(username: String) {
        viewModelScope.launch {
            val userConnect = UserApi.UserService.findOneUser(username)
            userConnect?.let {
                if (it.isSuccessful) {
                    userRepo.loginUser(it.body())
                    _tryConnection.value = true
                } else {
                    if (it.code() == 400) {
                        _errorConnection.value = "Please fill out the field"
                    }
                    if (it.code() == 401) {
                        _errorConnection.value = "User already exists"
                    }
                    if (it.code() == 404) {
                        _errorConnection.value = "User does no exist"
                    }
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
                    _tryConnection.value = true
                } else {
                    if (it.code() == 400) {
                        _errorConnection.value = "Please fill out the field"
                    }
                    if (it.code() == 401) {
                        _errorConnection.value = "User already exists"
                    }
                    if (it.code() == 404) {
                        _errorConnection.value = "User does no exist"
                    }
                }
            }
        }
    }


}