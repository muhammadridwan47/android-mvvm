package com.example.moviesapp.di

import com.example.moviesapp.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun  provideMovieRepository(): MovieRepository {
        return MovieRepository()
    }

}
