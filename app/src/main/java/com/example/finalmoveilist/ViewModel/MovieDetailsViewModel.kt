package com.example.finalmoveilist.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalmoveilist.MovieDetails
import com.example.finalmoveilist.Repository.QuotesRepository
import kotlinx.coroutines.launch

class MovieDetailsViewModel(val quotesRepository: QuotesRepository):ViewModel() {


    suspend fun getDetails(id: String) {
        viewModelScope.launch {

            quotesRepository.getMoviesDetails("e5311742", id)

        }
    }

    val detailsLiveData: LiveData<MovieDetails>
        get() = quotesRepository.moviesDetailsLiveData
}