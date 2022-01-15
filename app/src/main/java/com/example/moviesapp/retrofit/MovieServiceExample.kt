package com.example.moviesapp.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface MovieServiceExample {
  @GET("/3/movie/now_playing?api_key=74078d381713cfc6b144cc4fc1e7aaef")
  fun getMovies(): Call<GetMoviesResponse>
}