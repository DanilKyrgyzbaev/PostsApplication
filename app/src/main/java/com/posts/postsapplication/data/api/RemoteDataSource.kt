package com.posts.postsapplication.data.api

import com.posts.postsapplication.data.model.PostsModel
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllPosts() = apiService.getAllPosts()
    suspend fun postPosts(body: PostsModel) = apiService.postPost(body = body)
    suspend fun putPosts(id: String, body: PostsModel) = apiService.putPost(id = id, body = body)
    suspend fun patchPosts(id: String, body: PostsModel) = apiService.patchPost(id = id, body = body)
    suspend fun deletePosts(id: String) = apiService.deletePost(id = id)
}