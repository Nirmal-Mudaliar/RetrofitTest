package com.example.retrofittest.data.api

import com.example.retrofittest.data.model.Post
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost(): Post
}