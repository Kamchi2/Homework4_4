package com.example.homework4_4.ui.adapters.popularvideo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.homework4_4.base.BaseDiffUtilItemCallback
import com.example.homework4_4.databinding.ItemPopularVideoBinding
import com.example.homework4_4.models.VideoItem
import com.example.homework4_4.models.VideoItemSnippet

class PopularVideoListAdapter :
    ListAdapter<VideoItem, PopularVideoListAdapter.PopularVideoViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularVideoViewHolder =
        PopularVideoViewHolder(
            ItemPopularVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: PopularVideoViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it.snippet) }
    }

    class PopularVideoViewHolder(private val binding: ItemPopularVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: VideoItemSnippet) {
            binding.videoNameTv.text = model.title
            binding.videoProfileNameTv.text = model.channelTitle
            binding.videoUploadTimeTv.text = model.publishedAt
            binding.videoIconIv.load(model.thumbnails.image.url)
        }
    }

}