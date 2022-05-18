package com.example.core.di

import com.example.core.MovieRepository
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
