package com.dscnsut.app.events

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventsViewModel: ViewModel() {

    private val eventsRepo = EventsRepository()

    val events = MutableLiveData<List<EventsModel>>()

    fun getEvents() {
        eventsRepo.getEvents(events)
    }
}