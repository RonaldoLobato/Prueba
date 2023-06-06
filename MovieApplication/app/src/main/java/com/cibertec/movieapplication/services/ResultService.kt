package com.cibertec.movieapplication.services

import com.cibertec.movieapplication.entities.MoviedbResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ResultService {

    @Headers("accept: application/json")
    @GET("movie/popular")
    fun getListPopularMovies(@Query("language") language: String, @Query("page") page: Long, @Header("Authorization") token: String): Call<MoviedbResult>
}