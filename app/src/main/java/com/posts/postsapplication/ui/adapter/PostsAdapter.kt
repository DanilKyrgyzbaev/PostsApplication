package com.posts.postsapplication.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.posts.postsapplication.data.model.PostsModel
import com.posts.postsapplication.databinding.ItemPostsBinding

class PostsAdapter(private val postsList: ArrayList<PostsModel>) : RecyclerView.Adapter<PostsViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<PostsModel>) {
        postsList.clear()
        postsList.addAll(data)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = ItemPostsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = postsList[position]
        holder.binding.title.text = post.title
        holder.binding.body.text = post.body
    }
}


class PostsViewHolder(val binding: ItemPostsBinding) : RecyclerView.ViewHolder(binding.root)

