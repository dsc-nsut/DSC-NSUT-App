package com.dscnsut.app.blog

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import com.google.gson.annotations.Expose

data class BlogModel (
    @DocumentId
    val content: String? = null,
    @Expose
    val author: String? = null,
    @Expose
    val email: String? = null,
    @Expose
    val webstie: String? = null,
    @Expose
    val github: String? = null,
    @Expose
    val date: Timestamp? = null,
)
