package com.bdev.laboratorio05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bdev.laboratorio05.R
import com.bdev.laboratorio05.databinding.FragmentCreateMovieBinding
import com.bdev.laboratorio05.databinding.FragmentMovieBinding
import com.bdev.laboratorio05.ui.movie.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel: MovieViewModel by activityViewModels { MovieViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // ACTIVIAR EL DATA BINDING
        binding = FragmentMovieBinding.inflate(inflater, container, false)


        // RETORNAMOS EL BINDING.ROOT
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()

    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }
}