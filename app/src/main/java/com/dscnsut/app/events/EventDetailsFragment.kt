package com.dscnsut.app.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.dscnsut.app.R
import com.dscnsut.app.blogs.BlogDetailsFragmentArgs

class EventDetailsFragment : Fragment() {

    val safeArgs : EventDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val event = safeArgs.event

        val view = inflater.inflate(R.layout.fragment_event_details, container, false)
        view.findViewById<TextView>(R.id.description).setText(event.description)
        view.findViewById<TextView>(R.id.speaker).setText(event.speaker)
        view.findViewById<TextView>(R.id.date).setText(event.date.toString())
        view.findViewById<TextView>(R.id.topic).setText(event.topic)
        view.findViewById<TextView>(R.id.registrationLink).setText(event.registrationLink)

        return view
    }
}