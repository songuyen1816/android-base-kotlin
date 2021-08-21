package com.bsp.basekotlin.repository

import com.bsp.basekotlin.data.model.FilmItem
import com.bsp.basekotlin.data.remote.response.Response

import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    suspend fun getListFilm(): Flow<Response<List<FilmItem>>>
}
