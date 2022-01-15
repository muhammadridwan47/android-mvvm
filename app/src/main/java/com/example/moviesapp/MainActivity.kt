  package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.retrofit.MovieServiceExample
import com.example.moviesapp.retrofit.RetrofitClient


  class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val movieList : RecyclerView =  findViewById(R.id.list_movie)
    val retrofit = RetrofitClient().getRetrofitInstance()
    val serviceMovie = retrofit?.create(MovieServiceExample::class.java)
    val repository = MovieRepository(service = serviceMovie)

    val vm = ViewModelProvider(this, MainViewModel.Factory(repository)).get(MainViewModel::class.java)



    vm.movies.observe(this, {movies ->
      movieList.apply {
        adapter = MovieCardAdapter(movies.toTypedArray())
      }

    })


  }

  }


