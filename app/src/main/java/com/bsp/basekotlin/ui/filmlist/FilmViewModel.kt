package com.bsp.basekotlin.ui.filmlist

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bsp.basekotlin.data.model.FilmItem
import com.bsp.basekotlin.repository.FilmRepository
import com.bsp.basekotlin.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    application: Application,
    val filmRepository: FilmRepository
) : BaseViewModel(application) {

    private val _listFilm = MutableLiveData<List<FilmItem>>()

    val listFilm: LiveData<List<FilmItem>> = _listFilm

    fun getListFilm() {
        viewModelScope.launch {
            showLoading()
            filmRepository.getListFilm().catch {
                hideLoading()
                handleError(it)
            }.collect {
                hideLoading()
                _listFilm.postValue(it.data)
            }
        }
    }
}