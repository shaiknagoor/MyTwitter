package com.androiddevs.mvvmnewsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.live.mytwitter.repository.TweetsRepository
import com.live.mytwitter.viewmodel.TweetsViewModel

class NewViewModelProviderFactory (val tweetsRepository: TweetsRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return TweetsViewModel(tweetsRepository) as T
    }

}