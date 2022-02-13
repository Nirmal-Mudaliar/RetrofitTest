package com.example.retrofittest.data.repository

import com.example.retrofittest.data.api.RetrofitInstance
import com.example.retrofittest.data.model.Post

class PostRepo {
    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}