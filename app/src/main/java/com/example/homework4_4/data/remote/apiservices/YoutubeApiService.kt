package com.example.homework4_4.data.remote.apiservices

import com.example.homework4_4.models.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApiService {

    @GET("videos")
    suspend fun fetchVideos(
        @Query("part") part: String,
        @Query("chart") chart: String,
        @Query("maxResults") maxResults: Int
    ): VideoResponse
}
