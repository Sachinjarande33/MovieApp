package com.example.finalmoveilist

import android.app.Application
import com.example.finalmoveilist.Repository.QuotesRepository
import com.example.finalmoveilist.services.QuotesApi
import com.example.finalmoveilist.services.RetrofitHelper
import com.example.finalmoveilist.room.AppDatabase

class MoviesApplication:Application() {
lateinit var quotesRepository: QuotesRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
       setUp()
    }

    private fun setUp() {
        val apiMovieDetailsList = RetrofitHelper().getRetrofitMoviesDetails().create(QuotesApi::class.java)
        val database = AppDatabase.getDatabase(applicationContext)
        quotesRepository = QuotesRepository(apiMovieDetailsList, database)
    }

    private fun initialize() {
        val apiMovieList = RetrofitHelper().getRetrofitMoviesList().create(QuotesApi::class.java)
        val database = AppDatabase.getDatabase(applicationContext)
         quotesRepository = QuotesRepository(apiMovieList, database)
    }
}