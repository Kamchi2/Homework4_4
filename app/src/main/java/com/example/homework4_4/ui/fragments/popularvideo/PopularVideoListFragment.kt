package com.example.homework4_4.ui.fragments.popularvideo

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework4_4.base.BaseFragment
import com.example.homework4_4.R
import com.example.homework4_4.databinding.FragmentPopularVideoBinding
import com.example.homework4_4.ui.adapters.popularvideo.PopularVideoListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularVideoListFragment :
    BaseFragment<FragmentPopularVideoBinding, PopularVideoViewModel>(R.layout.fragment_popular_video) {

    override val binding by viewBinding(FragmentPopularVideoBinding::bind)
    override val viewModel: PopularVideoViewModel by viewModels()
    private val adapter = PopularVideoListAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.videosRv.adapter = adapter
    }

    override fun setupSubscribes() {
        viewModel.fetchVideos().subscribe(
            onSuccess = {
                adapter.submitList(it.items)
            },
            onError = {
                Log.e("log", it)
            }
        )
    }
}