package com.posts.postsapplication.domain.usecase

import com.posts.postsapplication.data.model.PostsModel
import com.posts.postsapplication.data.repository.PostRepositoryImpl
import javax.inject.Inject

class PostPostUseCase @Inject constructor(private val postRepositoryImpl: PostRepositoryImpl) {
    suspend fun execute(body: PostsModel) = postRepositoryImpl.postPost(body = body)
}