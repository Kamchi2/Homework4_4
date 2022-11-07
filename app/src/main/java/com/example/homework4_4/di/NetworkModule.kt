package com.example.homework4_4.di

import com.example.homework4_4.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideYoutubeApiService(retrofitClient: RetrofitClient) = retrofitClient.provideYoutubeApiService()

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

}