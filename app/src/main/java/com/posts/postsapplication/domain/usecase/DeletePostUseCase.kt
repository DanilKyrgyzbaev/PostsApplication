package com.posts.postsapplication.domain.usecase

import com.posts.postsapplication.data.repository.PostRepositoryImpl
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(private val postRepositoryImpl: PostRepositoryImpl) {
    suspend fun execute(id: String) = postRepositoryImpl.deletePost(id = id)
}
