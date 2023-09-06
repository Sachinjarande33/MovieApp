package com.example.finalmoveilist.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finalmoveilist.InnsightModel.MoviesInnSight
import com.example.finalmoveilist.MovieDetails
import com.example.finalmoveilist.services.QuotesApi
import com.example.finalmoveilist.room.AppDatabase


class QuotesRepository(private val quotesApi: QuotesApi, private val appDatabase: AppDatabase) {



    private val moviesMutableInnSightData = MutableLiveData<MoviesInnSight>()
    val moviesInnSightLiveData : LiveData<MoviesInnSight>
        get() = moviesMutableInnSightData


    private val moviesDetailsMutabledata = MutableLiveData<MovieDetails>()
    val moviesDetailsLiveData : LiveData<MovieDetails>
        get() = moviesDetailsMutabledata


    suspend fun getMoviesList(apiKey:String, s: String, page:Int) {
        val result = quotesApi.getMoviesList(apiKey,s,page)
        if (result?.body() != null) {
            moviesMutableInnSightData.postValue(result.body())
        }
    }

    suspend fun getMoviesDetails(apiKey:String, imdbId: String) {
        val result = quotesApi.getMovieDetails(apiKey,imdbId)
        if (result?.body() != null) {
 /*           GlobalScope.launch {
                appDatabase.detailsDao().insertDetails(result.body().also { details ->
                    if (details != null) {
                        details.Title
                        details.Actors
                        details.Writer
                        details.imdbRating
                        details.imdbVotes
                        details.Released
                    }

                })
            }*/
            moviesDetailsMutabledata.postValue(result.body())
        }
    }
}