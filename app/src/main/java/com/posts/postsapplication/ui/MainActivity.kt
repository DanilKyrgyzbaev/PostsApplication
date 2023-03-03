package com.posts.postsapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.posts.postsapplication.data.model.PostsModel
import com.posts.postsapplication.databinding.ActivityMainBinding
import com.posts.postsapplication.ui.adapter.PostsAdapter
import com.posts.postsapplication.utils.ResultStatus
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: PostsAdapter

    private val string = "Hello World!!!"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = PostsAdapter(ArrayList())
        binding.recyclerView.adapter = adapter

        viewModel.allPostResponse.observe(this) {
            when (it) {
                is ResultStatus.Loading -> {
                    Toast.makeText(this@MainActivity, "Get AllPosts...", Toast.LENGTH_SHORT)
                        .show()
                }
                is ResultStatus.Success -> {
                    val data = viewModel.allPostResponse.value
                    val postsList = ArrayList<PostsModel>()

                    if (data != null && data is ResultStatus.Success) {
                        val post = data.data
                        val posts = post
                        if (posts != null) {
                            postsList.addAll(posts)
                        }
                        Log.e("Adapter", "$postsList")
                        posts?.let { adapter.updateData(it) }
                    }
                }
                is ResultStatus.Error -> {
                    Log.e("Error", "${it.message}")
                }
            }
        }
    }
}
