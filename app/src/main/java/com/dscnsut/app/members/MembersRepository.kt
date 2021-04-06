package com.dscnsut.app.members

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class MembersRepository {
    val membersRef = FirebaseFirestore.getInstance().collection("members")

    fun getMembers(members: MutableLiveData<List<MembersModel>>) {
        membersRef.get()
            .addOnSuccessListener {
                members.value = it.toObjects(MembersModel::class.java)
                Log.d("MembersRepository", "getMembers: ${members}")
            }
            .addOnFailureListener {
                Log.d("MembersRepository", "getMembers: ${it.message}")
            }
    }

}