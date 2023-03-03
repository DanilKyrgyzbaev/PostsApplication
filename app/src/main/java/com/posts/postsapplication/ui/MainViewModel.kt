package com.posts.postsapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.posts.postsapplication.data.model.PostsModel
import com.posts.postsapplication.domain.usecase.*
import com.posts.postsapplication.utils.ResultStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val deletePostUseCase: DeletePostUseCase,
    private val patchPostUseCase: PatchPostUseCase,
    private val postPostUseCase: PostPostUseCase,
    private val putPostUseCase: PutPostUseCase
) : ViewModel(){
    private val _allPostsResponse = MutableLiveData<ResultStatus<List<PostsModel>>>()
    val allPostResponse: LiveData<ResultStatus<List<PostsModel>>> get() = _allPostsResponse
    init {
        getAllPosts()
    }

    private fun getAllPosts() {
        viewModelScope.launch {
            getAllPostsUseCase.execute().let {
                _allPostsResponse.value = it
            }
        }
    }
}