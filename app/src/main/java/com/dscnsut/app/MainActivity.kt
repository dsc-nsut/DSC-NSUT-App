package com.dscnsut.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dscnsut.app.members.MembersViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewmodel = ViewModelProvider(this).get(MembersViewModel::class.java)
        viewmodel.getMembers()
        viewmodel.members.observe(this, {membersList->
        if(membersList.isEmpty()) {
            println("List is Empty")
        }
        else
            println(membersList)
        })
    }
}