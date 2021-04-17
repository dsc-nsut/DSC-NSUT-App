package com.dscnsut.app.blogs

import androidx.lifecycle.MutableLiveData

class BlogsViewModel {
    val blogsRepo = BlogsRepository()
    val blogs = MutableLiveData<List<BlogsModel>>()
    fun getBlogs(){
        blogsRepo.getBlogs(blogs)
    }
}