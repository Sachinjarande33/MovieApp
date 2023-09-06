package com.example.finalmoveilist.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finalmoveilist.Repository.QuotesRepository

class MoviedetailsFactory(val quotesRepository: QuotesRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieDetailsViewModel(quotesRepository) as T
    }
}