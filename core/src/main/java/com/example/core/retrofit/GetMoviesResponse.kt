package com.example.core.retrofit

import com.example.core.MovieItem

data class GetMoviesResponse(
  val page: Int,
  val results: List<MovieItem>
)