package com.example.finalmoveilist.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finalmoveilist.MovieDetails

@Database(entities = [MovieDetails::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun detailsDao(): DetailsDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        AppDatabase::class.java,
                        "details")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }


}