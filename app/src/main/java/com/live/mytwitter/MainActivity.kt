package com.live.mytwitter
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.mvvmnewsapp.viewmodel.NewViewModelProviderFactory
import com.live.mytwitter.repository.TweetsRepository
import com.live.mytwitter.util.Resource
import com.live.mytwitter.viewmodel.TweetsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: TweetsViewModel
    lateinit var tweetAdapter: TweetAdapter
    val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tweetsRepository=TweetsRepository(this)
        val viewModelProviderFactory= NewViewModelProviderFactory(tweetsRepository)
       viewModel= ViewModelProvider(this,viewModelProviderFactory).get(TweetsViewModel::class.java)
      //  viewModel =  ViewModelProvider(this).get(TweetsViewModel::class.java)

        /*val newsRepository=NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory= NewViewModelProviderFactory(newsRepository)
         viewModel=ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)*/
        setupRecycler()
        viewModel.tweetList.observe(this, Observer {response->
            when(response){
                is Resource.Success->{
                   // hideProgresBar()
                    response.data?.let { newRes->
                        tweetAdapter.differ.submitList(newRes.data)
                    }
                }
                is Resource.Error->{
                    response.message?.let {
                        Log.e(TAG,it + "- error occurred-")
                    }
                }
                is Resource.Loading->{
                //    showProgresBar()
                }

            }
        })
    }
    private fun setupRecycler() {
        tweetAdapter=TweetAdapter()
        recylerv.apply {
            adapter=tweetAdapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
    }

}