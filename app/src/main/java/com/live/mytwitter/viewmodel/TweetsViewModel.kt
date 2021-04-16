
package com.live.mytwitter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.api.ApiClient
import com.live.mytwitter.model.ServerResponse
import com.live.mytwitter.repository.TweetsRepository
import com.live.mytwitter.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class TweetsViewModel (val tweetsRepository: TweetsRepository): ViewModel() {
 val tweetList:MutableLiveData<Resource<ServerResponse>> = MutableLiveData()
    init {
        getTweets()
    }
    fun getTweets(){
        viewModelScope.launch {
            tweetList.postValue(Resource.Loading())
           val response= tweetsRepository.getTweets()
            tweetList.postValue(handleTweetsResponse(response))

        }

    }

    private fun handleTweetsResponse(response: Response<ServerResponse>): Resource<ServerResponse>? {
       if(response.isSuccessful){
           response.body()?.let {
               return Resource.Success(it)
           }
       }
        return Resource.Error(response.message())

    }


}