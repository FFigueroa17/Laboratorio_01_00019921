package com.example.laboratorio05.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.model.MovieWithActor

@Dao
interface MovieDao {

    // Get all movies

    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies(): List<MovieModel>

    // Insert movie

    @Transaction
    @Insert
    suspend fun insertMovie(movie: MovieModel)

    // Get movie with actors by id

    @Query("SELECT * FROM movie_table WHERE movieId = :movieId")
    suspend fun getMovieWithActors(movieId: Int): MovieWithActor?
}