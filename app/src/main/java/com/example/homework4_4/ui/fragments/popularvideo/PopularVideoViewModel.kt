package com.example.homework4_4.ui.fragments.popularvideo

import com.example.homework4_4.base.BaseViewModel
import com.example.homework4_4.data.repositorys.YoutubeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularVideoViewModel @Inject constructor(private val repository: YoutubeRepository) :
    BaseViewModel() {

    fun fetchVideos() = repository.fetchVideos("snippet", "mostPopular", 20)

}