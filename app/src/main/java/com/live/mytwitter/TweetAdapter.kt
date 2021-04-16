package com.live.mytwitter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.live.mytwitter.model.Data
import kotlinx.android.synthetic.main.twitter_row.view.*


class TweetAdapter: RecyclerView.Adapter<TweetAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    }
    private val differCallBack=object : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
           return oldItem.profileImageUrl==newItem.profileImageUrl
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem==newItem
        }

    }
    val differ= AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.twitter_row,parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val tweet= differ.currentList.get(position)

        holder.itemView.apply {

            Glide.with(this).load(tweet.profileImageUrl).into(profile_image)
            tweet.apply {
            name_tv.text=name
                handle_tv.text=handle
                favoritec_tv.text=favoriteCount.toString()
                retweetc_tv.text =retweetCount.toString()
                text_tv.text=text

            }

        }
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }
}