package com.example.moviesapp

interface IMovieRepository {
  fun getMovies(onResponse : (list : List<MovieItem>) -> Unit, onFailure : (message : String) -> Unit)
}