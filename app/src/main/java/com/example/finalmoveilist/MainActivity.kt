package com.example.finalmoveilist

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalmoveilist.ViewModel.MovieListFactory
import com.example.finalmoveilist.ViewModel.MovieListModel

class MainActivity : AppCompatActivity() {

    lateinit var movieListModel: MovieListModel

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository= (application as MoviesApplication).quotesRepository
        movieListModel = ViewModelProvider(this,MovieListFactory(repository)).get(MovieListModel::class.java)

        val adapter = MovieListAdapter(emptyList())
        recyclerView = findViewById(R.id.quotesList)
        val orientation = resources.configuration.orientation
        val spanCount = if (orientation == Configuration.ORIENTATION_LANDSCAPE) 5 else 3
        recyclerView.layoutManager = GridLayoutManager(this, spanCount)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        movieListModel.moviesInnSightLiveData.observe(this) {
            adapter.setMovies(it.Search)
        }

    }
}