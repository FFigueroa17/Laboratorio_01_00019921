package com.bdev.laboratorio05.ui.movie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.bdev.laboratorio05.MovieReviewerApplication
import com.bdev.laboratorio05.data.models.MovieModel
import com.bdev.laboratorio05.repository.MovieRepository

class MovieViewModel( private val repository: MovieRepository) : ViewModel() {

    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description= MutableLiveData("")
    var qualification = MutableLiveData("")

    // PARA EL STATUS
    var status = MutableLiveData("")


    // OBTENER LAS PELICULAS
    fun getMovies() = repository.getMovies()


    // AGREGAR PELICULAS
    private fun addMovies(newMovie: MovieModel) = repository.addMovie(newMovie)

    fun createMovie(){

        if (!validateData()){
            status.value = WRONG_DATA
            return
        }

        val newMovie = MovieModel(
            name.value.toString(), // se utuliza ".value" por la estructura del live data, accedes al valor que almacena el live data
            category.value.toString(),
            description.value.toString(),
            qualification.value.toString()
        )

        addMovies(newMovie)
        status.value = MOVIE_CREATED
    }


    // LIMPIAR LA DATA

    fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }

    // ESTABLECER UN ESTADO BASE

    fun clearState(){
        status.value = BASE_STATE
    }

    private fun validateData() : Boolean{
        when
        {

            // FIX = " .VALUE"
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }

        return true
    }


    fun setSelectedMovie(movie: MovieModel){
        name.value = movie.name
        category.value = movie.category
        description.value = movie.description
        qualification.value = movie.qualification
    }


    companion object{

        // Es necesaria una factory, ya que por defecto el ViewModel no recibe parametros.
        // Si se le quiere pasar parametros, se debe crear una factory

        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_DATA = "Wrong information"
        const val BASE_STATE = ""
    }
}