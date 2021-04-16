package com.live.mytwitter.model

data class ServerResponse(
    val data: List<Data>,
    val success: Boolean
)