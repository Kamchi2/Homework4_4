package com.example.homework4_4.data.remote

import com.example.homework4_4.data.remote.interceptors.ApiKeyInterceptor
import com.example.homework4_4.data.remote.apiservices.YoutubeApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val retrofit = Retrofit.Builder().baseUrl("https://www.googleapis.com/youtube/v3/")
        .client(provideOkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build()

    private fun provideOkHttpClient() = OkHttpClient().newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(ApiKeyInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideYoutubeApiService() = retrofit.create(YoutubeApiService::class.java)
}