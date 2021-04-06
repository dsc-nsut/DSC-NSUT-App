package com.dscnsut.app.members

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MembersViewModel : ViewModel() {
    val membersRepo = MembersRepository()
    val members = MutableLiveData<List<MembersModel>>()
    fun getMembers(){
        membersRepo.getMembers(members)
    }
}