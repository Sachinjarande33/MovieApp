package com.example.finalmoveilist.room

import androidx.room.Dao
import androidx.room.Insert
import com.example.finalmoveilist.MovieDetails

@Dao
interface DetailsDao {

    @Insert
     fun insertDetails(details: MovieDetails?)


}