package com.bsp.basekotlin.di

import com.bsp.basekotlin.data.remote.api.ApiService
import com.bsp.basekotlin.repository.FilmRepository
import com.bsp.basekotlin.repository.FilmRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideFilmRepository(service: ApiService): FilmRepository {
        return FilmRepositoryImpl(service)
    }
}