package com.dscnsut.app.blogs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlogsViewModel : ViewModel(){
    val blogsRepo = BlogsRepository()
    val blogs = MutableLiveData<MutableList<BlogsModel>>()
    fun getBlogs(){
        blogsRepo.getBlogs(blogs)
    }
}