package com.example.finalmoveilist.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalmoveilist.InnsightModel.MoviesInnSight
import com.example.finalmoveilist.Repository.QuotesRepository
import kotlinx.coroutines.launch

class MovieListModel(val quotesRepository: QuotesRepository):ViewModel() {

    init {
        viewModelScope.launch {
            quotesRepository.getMoviesList("e5311742","Batman",1)
        }

    }

    val moviesInnSightLiveData : LiveData<MoviesInnSight>
        get() = quotesRepository.moviesInnSightLiveData
}