package com.androiddevs.mvvmnewsapp.api


import com.live.mytwitter.model.ServerResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiCall {
companion object{
   val BaseURL="https://6f8a2fec-1605-4dc7-a081-a8521fad389a.mock.pstmn.io/"
}
    @GET("tweets")
    suspend fun getTweets(
    ):Response<ServerResponse>

}