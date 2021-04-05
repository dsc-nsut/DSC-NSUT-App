package com.dscnsut.app.events

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import com.google.gson.annotations.Expose


data class EventsModel(
    @DocumentId
    val id: String? = null,
    @Expose
    val Description: String? = null,
    @Expose
    val Speaker: String? = null,
    @Expose
    val Topic: String? = null,
    @Expose
    val Date: Timestamp? = null
)