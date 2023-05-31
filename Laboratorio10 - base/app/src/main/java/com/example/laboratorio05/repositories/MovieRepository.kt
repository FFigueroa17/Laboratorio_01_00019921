package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.dao.MovieDao
import com.example.laboratorio05.data.model.MovieModel

class MovieRepository(private val moviesDao: MovieDao) {

    // getMovies() method
    suspend fun getMovies() = moviesDao.getAllMovies()

    // addMovies method
    suspend fun addMovies(movie: MovieModel) = moviesDao.insertMovie(movie)

    // getMoviesWithActors method
    suspend fun getMoviesWithActors(id: Int) = moviesDao.getMovieWithActors(id)

}