package com.example.retrofittest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofittest.R
import com.example.retrofittest.data.repository.PostRepo
import com.example.retrofittest.data.viewModel.PostViewModel
import com.example.retrofittest.data.viewModel.PostViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postRepo = PostRepo()
        val viewModelFatory = PostViewModelFactory(postRepo)
        postViewModel = ViewModelProvider(this, viewModelFatory).get(PostViewModel::class.java)
        postViewModel.getPost()
        postViewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.userId.toString())
                Log.d("Response", response.body()?.id.toString())
                Log.d("Response", response.body()?.title!!)
                Log.d("Response", response.body()?.body!!)
            }
            else {
                Log.d("Response: Error: ", response.errorBody().toString())
            }
        })


    }
}