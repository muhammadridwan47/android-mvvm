package com.example.moviesapp.retrofit

import com.example.moviesapp.MovieItem

data class GetMoviesResponse(
  val page: Int,
  val results: List<MovieItem>
)