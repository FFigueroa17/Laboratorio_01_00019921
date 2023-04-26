package com.bdev.laboratorio05.ui.movie

import android.os.Binder
import android.os.Bundle
import android.text.Spannable.Factory
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bdev.laboratorio05.R
import com.bdev.laboratorio05.data.models.MovieModel
import com.bdev.laboratorio05.databinding.FragmentCreateMovieBinding

class CreateMovieFragment : Fragment() {

    private lateinit var binding: FragmentCreateMovieBinding

    private val viewModel: MovieViewModel by activityViewModels { MovieViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        binding = FragmentCreateMovieBinding.inflate(inflater, container, false)

       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.actionSubmitMovie.setOnClickListener {
           createMovie()
        }
    }


    private fun createMovie() {

        // Para no escribir el apply siempre.

        binding.apply {
            val newMovie = MovieModel(
                NameEditText.text.toString(),
                DescriptionEditText.text.toString(),
                CategoryEditText.text.toString(),
                CalificationEditText.text.toString()
            )

            viewModel.addMovies(newMovie)
        }


        Log.d("TAG APP", viewModel.getMovies().toString())

        findNavController().popBackStack()
    }
}