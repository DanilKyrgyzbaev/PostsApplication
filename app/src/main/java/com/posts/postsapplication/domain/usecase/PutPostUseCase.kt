package com.posts.postsapplication.domain.usecase

import com.posts.postsapplication.data.model.PostsModel
import com.posts.postsapplication.data.repository.PostRepositoryImpl
import javax.inject.Inject

class PutPostUseCase @Inject constructor(private val postRepositoryImpl: PostRepositoryImpl) {
    suspend fun execute(id: String, body: PostsModel) = postRepositoryImpl.putPost(id = id, body = body)
}