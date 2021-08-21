package com.bsp.basekotlin.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/** Use for post/subscribe event like EventBus **/
object EventProvider {
    private val liveDataEvent = MutableLiveData<Event<AppEvent>>()

    fun post(event: AppEvent) {
        this.liveDataEvent.postValue(Event(event))
    }

    fun subscribe(): LiveData<Event<AppEvent>> = liveDataEvent
}

enum class AppEvent {

}