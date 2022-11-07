package com.example.homework4_4.data.repositorys

import com.example.homework4_4.base.BaseRepository
import com.example.homework4_4.data.remote.apiservices.YoutubeApiService
import javax.inject.Inject

class YoutubeRepository @Inject constructor(private val service: YoutubeApiService): BaseRepository() {

    fun fetchVideos(part: String, snippet : String, mostPopular : Int) = doRequest {
        service.fetchVideos(part, snippet, mostPopular)
    }

}