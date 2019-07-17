package com.e.t2tproject.ui

import androidx.databinding.ObservableField
import androidx.databinding.ObservableLong
import androidx.lifecycle.ViewModel
import com.e.t2tproject.data.models.Event

class EventItemViewModel : ViewModel() {

    val id = ObservableLong()
    val name = ObservableField<String>()

    fun start(event: Event) {
        id.set(event.id)
        name.set(event.name)
    }
}