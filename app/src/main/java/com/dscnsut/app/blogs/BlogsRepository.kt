package com.dscnsut.app.blogs

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class BlogsRepository {
    val blogsRef = FirebaseFirestore.getInstance().collection("blogs")

    fun getBlogs(blogs: MutableLiveData<List<BlogsModel>>) {
        blogsRef.get()
            .addOnSuccessListener {
                blogs.value = it.toObjects(BlogsModel::class.java)
            }
            .addOnFailureListener {
                Log.d("BlogsRepository", "getBlogs: ${it.message}")
            }
    }
}