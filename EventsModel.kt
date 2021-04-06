package com.dscnsut.app.events

import com.google.firebase.firestore.DocumentId
import com.google.gson.annotations.Expose

data class EventsModel(
    @DocumentId
    val id: String? = null,
    @Expose
    val description: String? = null,
    @Expose
    val speaker: String? = null,
    @Expose
    val topic: String? = null,
    @Expose
    val date: Long? = null,
    @Expose
    val registrationLink: String? = null
)