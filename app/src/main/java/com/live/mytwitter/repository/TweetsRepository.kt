package com.live.mytwitter.repository

import android.content.Context
import com.androiddevs.mvvmnewsapp.api.ApiClient
import com.live.mytwitter.MainActivity

class TweetsRepository(context:Context) {
    suspend fun getTweets()=
        ApiClient.api.getTweets()
  /*  suspend fun getTweets(){
        ApiClient.api.getTweets()
    }*/
}