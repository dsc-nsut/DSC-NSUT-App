package com.dscnsut.app.blog

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class BlogRepository {
    private val blogRef = FirebaseFirestore.getInstance().collection("blog")

    fun getBlog(blogA: MutableLiveData<List<BlogModel>>)
    {
        blogRef.get()
            .addOnSuccessListener {
                blogA.value = it.toObjects(BlogModel::class.java)
            }

            .addOnFailureListener {
                Log.d("BlogRepository", "Blog: ${it.message}")
            }
    }
}