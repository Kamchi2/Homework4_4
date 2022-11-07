package com.example.homework4_4.models

import com.example.homework4_4.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("nextPageToken")
    val nextPageToken: String,
    @SerializedName("prevPageToken")
    val prevPageToken: String,
    @SerializedName("items")
    val items: List<VideoItem>
)

data class VideoItem(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("id")
    override val id: String,
    @SerializedName("snippet")
    val snippet: VideoItemSnippet,
    @SerializedName("statistics")
    val statistics: VideoStatistic
): IBaseDiffModel<String>

data class VideoStatistic(
    @SerializedName("viewCount")
    val viewCount: String
)
data class VideoItemSnippet(
    @SerializedName("title")
    val title: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("channelTitle")
    val channelTitle: String,
    @SerializedName("thumbnails")
    val thumbnails: ThumbnailImage
)

data class ThumbnailImage(
    @SerializedName("maxres")
    val image: VideoImage
)

data class VideoImage(
    @SerializedName("url")
    val url: String
)