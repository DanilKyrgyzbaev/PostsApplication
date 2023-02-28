package com.posts.postsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.posts.postsapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val string = "Hello World!!!"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.text.text = "$string Android"
    }
}