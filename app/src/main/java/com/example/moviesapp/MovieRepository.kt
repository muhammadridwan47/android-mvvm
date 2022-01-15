package com.example.moviesapp

import com.example.moviesapp.retrofit.GetMoviesResponse
import com.example.moviesapp.retrofit.MovieServiceExample
import com.example.moviesapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository constructor(private val service : MovieServiceExample?) : IMovieRepository {
    override fun getMovies(onResponse : (list : List<MovieItem>) -> Unit, onFailure : (message : String) -> Unit){
        val retrofit = RetrofitClient().getRetrofitInstance()
        val serviceMovie = retrofit?.create(MovieServiceExample::class.java)
        val call = serviceMovie?.getMovies()

        call?.enqueue(object : Callback<GetMoviesResponse>{
            override fun onResponse(
                call: Call<GetMoviesResponse>,
                response: Response<GetMoviesResponse>
            ) {
                val list = response.body()?.results
                if (response.isSuccessful && list != null) {
                    onResponse(list)
                } else {
                    onResponse(listOf())
                }
            }

            override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                onFailure("error")
            }

        })
    }
}