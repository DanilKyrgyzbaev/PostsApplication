package com.posts.postsapplication.data.repository

import com.posts.postsapplication.data.api.RemoteDataSource
import com.posts.postsapplication.data.model.PostsModel
import com.posts.postsapplication.utils.BaseApiResponse
import com.posts.postsapplication.utils.ResultStatus
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource): BaseApiResponse() {
    suspend fun getAllPosts(): ResultStatus<List<PostsModel>> {
        return saveApiCall { remoteDataSource.getAllPosts() }
    }

    suspend fun postPost(body: PostsModel): ResultStatus<PostsModel> {
        return saveApiCall { remoteDataSource.postPosts(body = body) }
    }

    suspend fun putPost(id: String, body: PostsModel): ResultStatus<PostsModel> {
        return saveApiCall { remoteDataSource.putPosts(id = id, body = body) }
    }

    suspend fun patchPost(id: String, body: PostsModel): ResultStatus<PostsModel> {
        return saveApiCall { remoteDataSource.patchPosts(id = id, body = body) }
    }

    suspend fun deletePost(id: String): ResultStatus<PostsModel> {
        return saveApiCall { remoteDataSource.deletePosts(id = id) }
    }
}