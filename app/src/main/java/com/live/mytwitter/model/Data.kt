package com.live.mytwitter.model

data class Data(
    val favoriteCount: Int,
    val handle: String,
    val name: String,
    val profileImageUrl: String,
    val retweetCount: Int,
    val text: String
)