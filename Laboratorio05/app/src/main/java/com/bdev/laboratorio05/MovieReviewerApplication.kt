package com.bdev.laboratorio05

import android.app.Application
import com.bdev.laboratorio05.data.movies
import com.bdev.laboratorio05.repository.MovieRepository

class MovieReviewerApplication : Application(){

    // Se crea un repositorio de peliculas,
    // el cual se puede acceder desde cualquier parte de la aplicacion

    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}