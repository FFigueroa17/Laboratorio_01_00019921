package com.bdev.laboratorio05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.bdev.laboratorio05.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillBoardFragment : Fragment() {

    private lateinit var  actionNavToCreateMovie: FloatingActionButton
    private lateinit var  actionCardViewToDescription: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bill_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionNavToCreateMovie= view.findViewById(R.id.actionNavToCreateMovie)
        actionCardViewToDescription = view.findViewById(R.id.actionCardViewToDescription)

        actionNavToCreateMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billBoardFragment_to_createMovieFragment)
        }

        actionCardViewToDescription.setOnClickListener{
            it.findNavController().navigate(R.id.action_billBoardFragment_to_movieFragment)
        }
    }

}
