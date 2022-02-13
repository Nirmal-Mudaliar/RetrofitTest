package com.example.retrofittest.data.repository

import com.example.retrofittest.data.api.RetrofitInstance
import com.example.retrofittest.data.model.Post
import retrofit2.Response

class PostRepo {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}