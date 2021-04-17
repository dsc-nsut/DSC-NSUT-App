package com.dscnsut.app.blogs

import android.os.Parcel
import android.os.Parcelable
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
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(author)
        parcel.writeValue(timestamp)
        parcel.writeString(body)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BlogsModel> {
        override fun createFromParcel(parcel: Parcel): BlogsModel {
            return BlogsModel(parcel)
        }

        override fun newArray(size: Int): Array<BlogsModel?> {
            return arrayOfNulls(size)
        }
    }
}