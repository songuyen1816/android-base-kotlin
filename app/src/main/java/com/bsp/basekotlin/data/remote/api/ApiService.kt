package com.bsp.basekotlin.data.remote.api

import com.bsp.basekotlin.data.model.FilmItem
import com.bsp.basekotlin.data.remote.response.Response
import retrofit2.http.GET

interface ApiService {
    @GET("movie/list")
    suspend fun getFilmListAsync(): Response<List<FilmItem>>
}