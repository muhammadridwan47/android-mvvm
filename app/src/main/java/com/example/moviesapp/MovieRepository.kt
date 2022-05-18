package com.example.moviesapp

import com.example.moviesapp.retrofit.GetMoviesResponse
import com.example.moviesapp.retrofit.MovieServiceExample
import com.example.moviesapp.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository : IMovieRepository {
    override suspend fun getMovies(onResponse : (list : List<MovieItem>) -> Unit, onFailure : (message : String) -> Unit){
        val retrofit = RetrofitClient().getRetrofitInstance()
        val serviceMovie = retrofit?.create(MovieServiceExample::class.java)

        withContext(Dispatchers.IO) {

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
}