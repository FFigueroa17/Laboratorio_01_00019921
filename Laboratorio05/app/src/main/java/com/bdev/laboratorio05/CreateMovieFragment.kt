package com.bdev.laboratorio05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class CreateMovieFragment : Fragment() {

    private lateinit var actionSubmitMovie: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionSubmitMovie = view.findViewById(R.id.actionSubmitMovie)

        actionSubmitMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_createMovieFragment_to_billBoardFragment)
        }
    }
}