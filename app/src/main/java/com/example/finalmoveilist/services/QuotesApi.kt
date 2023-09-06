package com.example.finalmoveilist.services

import com.example.finalmoveilist.InnsightModel.MoviesInnSight
import com.example.finalmoveilist.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {

    @GET("/")
    suspend fun getMoviesList(@Query("apikey") apikey:String, @Query("s") s:String,@Query("page") page:Int):Response<MoviesInnSight>

    @GET("/")
    suspend fun getMovieDetails(@Query("apikey") apikey:String, @Query("i") imdbID:String):Response<MovieDetails>
}
