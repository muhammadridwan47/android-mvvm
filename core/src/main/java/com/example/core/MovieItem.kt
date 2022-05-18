package com.example.core

import com.google.gson.annotations.SerializedName

data class MovieItem(
  @SerializedName("poster_path")
  val image : String,
  val title : String
)
