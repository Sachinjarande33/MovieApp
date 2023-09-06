package com.example.finalmoveilist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.finalmoveilist.ViewModel.MovieDetailsViewModel
import com.example.finalmoveilist.ViewModel.MoviedetailsFactory
import com.example.finalmoveilist.databinding.ActivityMovieDetailsBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovieDetailsBinding
    lateinit var movieDetailsViewModel: MovieDetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        val repository = (application as MoviesApplication).quotesRepository
        movieDetailsViewModel = ViewModelProvider(
            this,
            MoviedetailsFactory(repository)
        ).get(MovieDetailsViewModel::class.java)

        GlobalScope.launch {
            var id = intent.getStringExtra("id")
            movieDetailsViewModel.getDetails(id as String)
        }

        movieDetailsViewModel.detailsLiveData.observe(this) {
            Log.d("ACTORS", it.Poster)
            binding.title.text = it.Title
            binding.actors.text = it.Actors
            binding.date.text = it.Released
            binding.imdbRating.text = it.imdbRating
            binding.imdbVoting.text = it.imdbVotes
            binding.writer.text = it.Writer
            binding.topTitle.text = it.Title
            // val url = it.Poster
            Glide.with(binding.posterDetails).load(it.Poster).into(binding.posterDetails)
        }

        binding.backPress.setOnClickListener {
            finish()
        }

    }
}