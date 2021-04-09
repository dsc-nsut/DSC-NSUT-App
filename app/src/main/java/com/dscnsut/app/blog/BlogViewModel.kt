package com.dscnsut.app.blog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlogViewMode: ViewModel() {
    private val blogRepo = BlogRepository()

    val blogList = MutableLiveData<List<BlogModel>>()

    fun getBlog()
    {
        blogRepo.getBlog(blogList)
    }

}