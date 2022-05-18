package com.example.core.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

  private var retrofit: Retrofit? = null
  private val BASE_URL = "https://api.themoviedb.org"
  
  fun getRetrofitInstance(): Retrofit? {
    if (retrofit == null) {
      retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
    return retrofit
  }
}