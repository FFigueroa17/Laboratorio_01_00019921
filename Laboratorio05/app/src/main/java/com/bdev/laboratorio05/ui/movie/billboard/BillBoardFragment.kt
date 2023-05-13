package com.bdev.laboratorio05.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bdev.laboratorio05.R
import com.bdev.laboratorio05.data.models.MovieModel
import com.bdev.laboratorio05.databinding.FragmentBillBoardBinding
import com.bdev.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.bdev.laboratorio05.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.selects.select

class BillBoardFragment : Fragment() {

    // INTEGRAR DATA BINDING

    private lateinit var binding: FragmentBillBoardBinding

    private lateinit var adapter: MovieRecyclerViewAdapter

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ACTIVAMOS DATA BINDING

        binding = FragmentBillBoardBinding.inflate(inflater, container, false)

        // RETORNAR EL BINDING.ROOT

        return binding.root
    }

    private fun showSelectedItem(movie: MovieModel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billBoardFragment_to_movieFragment)
    }


    private fun displayMovies() {
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recyclerView.adapter= adapter
        displayMovies()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.actionNavToCreateMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billBoardFragment_to_createMovieFragment)
        }
    }

}
