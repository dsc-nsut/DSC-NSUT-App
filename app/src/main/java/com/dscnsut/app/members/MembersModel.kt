package com.dscnsut.app.members

import com.google.firebase.firestore.DocumentId
import com.google.gson.annotations.Expose

data class MembersModel (
    @DocumentId
    val id: String? = null,
    @Expose
    val name: String? = null,
    @Expose
    val email: String? = null,
    @Expose
    val linkedin: String? = null,
    @Expose
    val instagram: String? = null,
    @Expose
    val github: String? = null,
    @Expose
    val twitter: String? = null,
    @Expose
    val picName: String? = null,
    @Expose
    val intro: String? = null,
)
