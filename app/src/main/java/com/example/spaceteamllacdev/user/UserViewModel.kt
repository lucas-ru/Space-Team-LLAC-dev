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


    init {
        _tryConnection.value = false
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
        _tryConnection.value = true
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
        _tryConnection.value = true
    }


}