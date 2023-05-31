package com.example.laboratorio05.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.laboratorio05.data.dao.ActorDao
import com.example.laboratorio05.data.dao.CastDao
import com.example.laboratorio05.data.dao.MovieDao
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.data.model.CastModel
import com.example.laboratorio05.data.model.MovieModel

@Database(entities = [MovieModel::class, ActorModel::class, CastModel::class], version = 2, exportSchema = false)
abstract class MovieReviewerDatabase : RoomDatabase(){
    // Declare DAOs
    abstract fun movieDao(): MovieDao
    abstract fun actorDao(): ActorDao
    abstract fun castDao(): CastDao

    // Companion object
    companion object{
        // Volatile allows other threads to immediately see when a thread changes this instance
        @Volatile
        private var INSTANCE: MovieReviewerDatabase? = null

        //newInstance method
        fun newInstance(application: Application) : MovieReviewerDatabase {
            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(
                    application.applicationContext,
                    MovieReviewerDatabase::class.java,
                    "movie_reviewer"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                instance
            }
        }
    }
}