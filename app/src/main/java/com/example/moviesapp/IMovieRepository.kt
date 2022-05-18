package com.example.moviesapp

interface IMovieRepository {
  suspend fun getMovies(onResponse : (list : List<MovieItem>) -> Unit, onFailure : (message : String) -> Unit)
}