package com.example.ticketscanner.services

import com.example.ticketscanner.dataModel.LoginModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginApiService {
    @GET("Get")
    suspend fun login(@Query("username") username: String, @Query("password") password: String): List<LoginModel>

    companion object {
        private const val BASE_URL = "https://eticket-uat.ckcloud.in/api/"

        fun create(): LoginApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LoginApiService::class.java)
        }
    }


}