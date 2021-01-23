package com.example.spaceteamllacdev.user

import androidx.lifecycle.GeneratedAdapter
import com.example.spaceteamllacdev.Models.User
import com.example.spaceteamllacdev.Models.UserPost
import com.squareup.moshi.JsonClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserApiServiceBLA {
    class RestApiService {


        /*fun addUser(userData: UserPost, onResult: (User?) -> Unit){
            val retrofit = UserServiceBuilder.buildService(UserApiRest::class.java)
            retrofit.addUser(userData).enqueue(
                object : Callback<UserPost> {
                    override fun onFailure(call: Call<UserPost>, t: Throwable) {
                        onResult(null)
                    }
                    override fun onResponse( call: Call<UserPost>, response: Response<User>) {
                        val addedUser = response.body()
                        onResult(addedUser)
                    }
                }
            )
        }*/

        /*fun addUser(userData: UserPost, onResult: (User?) -> Unit){
            val retrofit = UserServiceBuilder.buildService(UserApiRest::class.java)
            CoroutineScope(Dispatchers.IO).launch {
                val response = retrofit.addUser(userData)
                println(response)
            }
        }*/


    }
}


