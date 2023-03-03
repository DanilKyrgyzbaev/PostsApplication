package com.posts.postsapplication.data.api

import com.posts.postsapplication.data.model.PostsModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("/posts")
    suspend fun getAllPosts(): Response<List<PostsModel>>

    @POST("/posts")
    suspend fun postPost(@Body body: PostsModel): Response<PostsModel>

    @PUT("/posts/{id}")
    suspend fun putPost(@Path("id") id: String, @Body body: PostsModel): Response<PostsModel>

    @PATCH("/posts/{id}")
    suspend fun patchPost(@Path("id") id: String, @Body body: PostsModel): Response<PostsModel>

    @DELETE("/posts/{id}")
    suspend fun deletePost(@Path("id") id: String): Response<PostsModel>
}