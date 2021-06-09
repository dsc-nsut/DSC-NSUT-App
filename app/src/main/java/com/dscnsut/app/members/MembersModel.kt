package com.dscnsut.app.members

import android.os.Parcel
import android.os.Parcelable
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
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(linkedin)
        parcel.writeString(instagram)
        parcel.writeString(github)
        parcel.writeString(twitter)
        parcel.writeString(picName)
        parcel.writeString(intro)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MembersModel> {
        override fun createFromParcel(parcel: Parcel): MembersModel {
            return MembersModel(parcel)
        }

        override fun newArray(size: Int): Array<MembersModel?> {
            return arrayOfNulls(size)
        }
    }
}
