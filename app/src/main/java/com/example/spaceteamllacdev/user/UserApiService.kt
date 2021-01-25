package com.example.spaceteamllacdev.user

import com.example.spaceteamllacdev.models.User
import com.example.spaceteamllacdev.models.UserPost
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.*


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()



interface UserApiService {

    @GET("api/users")
    suspend fun getUsers(): Response<List<User>>

    @GET("api/user/find/{name}")
    suspend fun findOneUser(@Path("name") username: String): Response<User>?

    @Headers("Content-Type: application/json")
    @POST("api/user/register")
    suspend fun addUser(@Body user: UserPost): Response<User>?

}

object UserApi {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://spacedim.async-agency.com")
        .build()
    val UserService: UserApiService = retrofit.create(UserApiService::class.java)

}