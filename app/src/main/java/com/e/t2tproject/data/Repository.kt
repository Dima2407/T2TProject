package com.e.t2tproject.data

import android.content.Context
import android.content.res.AssetManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.e.t2tproject.common.loadJSONFromAsset
import com.e.t2tproject.data.models.Event
import com.e.t2tproject.data.models.EventsResponse
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository(context: Context) : CoroutineScope {

    override val coroutineContext = Dispatchers.Default

    private val assetManager: AssetManager

    init {
        assetManager = context.assets
    }

    fun getEvents(): LiveData<List<Event>> {
        val resultLiveData = MutableLiveData<List<Event>>()
        launch {
            val jsonFromAsset = loadJSONFromAsset(assetManager, "events.json")
            val eventsResponse = Gson().fromJson(jsonFromAsset, EventsResponse::class.java)
            resultLiveData.postValue(eventsResponse.events)
        }
        return resultLiveData
    }

    companion object {

        private var INSTANCE: Repository? = null

        fun getInstance(context: Context): Repository {
            if (INSTANCE == null) {
                INSTANCE = Repository(context)
            }
            return INSTANCE as Repository
        }
    }
}