package com.posts.postsapplication.domain.usecase

import com.posts.postsapplication.data.repository.PostRepositoryImpl
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(private val postsRepositoryImpl: PostRepositoryImpl) {
    suspend fun execute() = postsRepositoryImpl.getAllPosts()
}