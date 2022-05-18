package com.example.core

import com.example.core.retrofit.GetMoviesResponse
import com.example.core.retrofit.MovieServiceExample
import com.example.core.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository : IMovieRepository {
    override suspend fun getMovies(onResponse : (list : List<com.example.core.MovieItem>) -> Unit, onFailure : (message : String) -> Unit){
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