package com.example.finalmoveilist.InnsightModel



import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.finalmoveilist.Search
data class MoviesInnSight(

    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)