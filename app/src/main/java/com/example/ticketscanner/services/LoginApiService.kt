package com.example.ticketscanner.services

import com.example.ticketscanner.dataModel.LoginModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface LoginApiService {
    @GET("Get")
    suspend fun login(@Query("username") username: String, @Query("password") password: String): List<LoginModel>


    companion object {
        private const val BASE_URL = "https://eticket-uat.ckcloud.in/api/"
        private var TIMEOUT_DURATION = 30L

        private val okhttpClient = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
            .also {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                it.addInterceptor(logging)
            }

        private val okhttpClientBuilder = okhttpClient.build()

        fun create(): LoginApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okhttpClientBuilder)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LoginApiService::class.java)
        }
    }


}