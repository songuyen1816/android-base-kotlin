package com.bsp.basekotlin.repository

import com.bsp.basekotlin.data.model.FilmItem
import com.bsp.basekotlin.data.remote.api.ApiService
import com.bsp.basekotlin.data.remote.response.Response

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FilmRepositoryImpl (val service: ApiService) : FilmRepository {

    override suspend fun getListFilm(): Flow<Response<List<FilmItem>>> = flow {
        emit(service.getFilmListAsync())
    }
}