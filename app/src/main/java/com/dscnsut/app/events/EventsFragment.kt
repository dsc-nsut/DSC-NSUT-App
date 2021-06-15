package com.dscnsut.app.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.dscnsut.app.R
import com.dscnsut.app.members.MembersViewModel

class EventsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val eventView =  inflater.inflate(R.layout.fragment_events, container, false)

        val viewModel = ViewModelProvider(this).get(EventsViewModel::class.java)
        viewModel.getEvents()

        val recyclerView = eventView.findViewById<RecyclerView>(R.id.recycler_view)

        //set adapter

        return eventView
    }

}