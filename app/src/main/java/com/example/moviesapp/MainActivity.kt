  package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

  @AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      viewBinding =  ActivityMainBinding.inflate(layoutInflater)
      setContentView(viewBinding.root)

      val movieList : RecyclerView =  findViewById(R.id.list_movie)

      viewModel.movies.observe(this, {movies ->
        movieList.apply {
          adapter = MovieCardAdapter(movies.toTypedArray())
        }
      })


    }

}


