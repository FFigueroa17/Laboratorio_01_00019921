package com.bdev.laboratorio05.ui.movie

import android.text.Editable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.bdev.laboratorio05.MovieReviewerApplication
import com.bdev.laboratorio05.data.models.MovieModel
import com.bdev.laboratorio05.repository.MovieRepository

class MovieViewModel( private val repository: MovieRepository) : ViewModel() {

    fun getMovies() = repository.getMovies()

    fun addMovies(newMovie: MovieModel) = repository.addMovie(newMovie)

    companion object{

        // Es necesaria una factory, ya que por defecto el ViewModel no recibe parametros.
        // Si se le quiere pasar parametros, se debe crear una factory

        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}