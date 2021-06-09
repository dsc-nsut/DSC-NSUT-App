package com.dscnsut.app.members

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.dscnsut.app.R

class MembersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val memberView =  inflater.inflate(R.layout.fragment_members, container, false)

        val viewModel = ViewModelProvider(this).get(MembersViewModel::class.java)
        viewModel.getMembers()

        val recyclerView = memberView.findViewById<RecyclerView>(R.id.recycler_view)

        //set adapter

        return memberView
    }

}