package com.e.t2tproject.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import com.e.t2tproject.data.Repository
import com.e.t2tproject.data.models.Event

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val adapter = EventsAdapter()
    private val eventsLiveData = Repository.getInstance(application).getEvents()
    private val eventsObserver = Observer<List<Event>> { events ->
        adapter.items = events.filter { it.active }
    }

    init {
        eventsLiveData.observeForever(eventsObserver)
    }

    override fun onCleared() {
        super.onCleared()
        eventsLiveData.removeObserver(eventsObserver)
    }
}