package com.bsp.basekotlin.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bsp.basekotlin.utils.Event

abstract class BaseViewModel(application: Application): AndroidViewModel(application) {

    private val _loadingEvent = MutableLiveData(Event(false))
    val loadingEvent: LiveData<Event<Boolean>> = _loadingEvent

    private val _errorEvent = MutableLiveData<Event<String>>()
    val errorEvent: LiveData<Event<String>> = _errorEvent

    protected fun handleError(exception: Throwable){
        _errorEvent.postValue(Event(exception.message!!))
    }

    protected fun handleError(message: String){
        _errorEvent.postValue(Event(message))
    }

    protected fun showLoading(){
        _loadingEvent.postValue(Event(true))
    }

    protected fun hideLoading(){
        _loadingEvent.postValue(Event(false))
    }
}