package com.example.core

interface IMovieRepository {
  suspend fun getMovies(onResponse : (list : List<com.example.core.MovieItem>) -> Unit, onFailure : (message : String) -> Unit)
}