package com.dscnsut.app.events

import android.os.Parcel
import android.os.Parcelable
import com.dscnsut.app.blogs.BlogsModel
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
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(description)
        parcel.writeString(speaker)
        parcel.writeString(topic)
        parcel.writeValue(date)
        parcel.writeString(registrationLink)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EventsModel> {
        override fun createFromParcel(parcel: Parcel): EventsModel {
            return EventsModel(parcel)
        }

        override fun newArray(size: Int): Array<EventsModel?> {
            return arrayOfNulls(size)
        }
    }
}