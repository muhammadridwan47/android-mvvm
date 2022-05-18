package com.example.moviesapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private  val repository: MovieRepository) : ViewModel() {
  private var _movies = MutableLiveData<List<MovieItem>>();
  val movies : LiveData<List<MovieItem>> = _movies;

  val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)

  init {
    getMovies()
  }

  private fun getMovies(){

    coroutineScope.launch {
      repository.getMovies({movies ->
        Log.d("MoviesData", movies.toString())
        _movies.value = movies
      }, {errorMessage ->
        print(errorMessage)
      })
    }

  }
}