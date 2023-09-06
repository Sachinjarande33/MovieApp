package com.example.finalmoveilist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "details")
data class MovieDetails(
    var Actors: String,
    val Awards: String,
    val BoxOffice: String,
    var Country: String,
    val DVD: String,
    var Director: String,
    val Genre: String,
    val Language: String,
    val Metascore: String,
    val Plot: String,
    val Poster: String,
    val Production: String,
    val Rated: String,
    //val Ratings: List<Rating>,
    var Released: String,
    val Response: String,
    val Runtime: String,
    val Title: String,
    val Type: String,
    val Website: String,
    var Writer: String,
    val Year: String,
    @PrimaryKey
    val imdbID: String,
    var imdbRating: String,
    var imdbVotes: String
)