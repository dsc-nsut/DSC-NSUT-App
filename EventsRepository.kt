package com.dscnsut.app.events

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class EventsRepository {

    private val eventsRef = FirebaseFirestore.getInstance().collection("events")

    fun getEvents(events: MutableLiveData<List<EventsModel>>) {
        eventsRef.get()
            .addOnSuccessListener {
                //QuerySnapshot
                events.value = it.toObjects(EventsModel::class.java)
            }
            .addOnFailureListener {
                Log.d("EventsRepo", "getEvents: ${it.message}")
            }
    }

}

