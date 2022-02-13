package com.example.retrofittest.data.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittest.data.model.Post
import com.example.retrofittest.data.repository.PostRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class PostViewModel(private val repository: PostRepo): ViewModel() {
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }
}