package com.dscnsut.app.blogs

import com.google.firebase.firestore.DocumentId
import com.google.gson.annotations.Expose

data class BlogsModel(
    @DocumentId
    val id: String? = null,
    @Expose
    val title: String? = null,
    @Expose
    val author: String? = null,
    @Expose
    val timestamp: Long? = null,
    @Expose
    val body: String? = null,
)