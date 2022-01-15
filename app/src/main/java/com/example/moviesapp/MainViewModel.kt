package com.example.moviesapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(private  val repository: MovieRepository) : ViewModel() {
  private var _movies = MutableLiveData<List<MovieItem>>();
  val movies : LiveData<List<MovieItem>> = _movies;



  init {
    getMovies()
  }

  private fun getMovies(){
    repository.getMovies({movies ->
      Log.d("MoviesData", movies.toString())
      _movies.value = movies
    }, {errorMessage ->
      print(errorMessage)
    })
  }


  class Factory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(repository) as T
      }
      throw IllegalArgumentException("Unable to construct viewmodel")
    }
  }



}