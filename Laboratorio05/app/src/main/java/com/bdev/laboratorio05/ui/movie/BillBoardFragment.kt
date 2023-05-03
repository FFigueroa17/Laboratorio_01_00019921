package com.bdev.laboratorio05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.bdev.laboratorio05.R
import com.bdev.laboratorio05.databinding.FragmentBillBoardBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillBoardFragment : Fragment() {

    // INTEGRAR DATA BINDING

    private lateinit var binding : FragmentBillBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ACTIVAMOS DATA BINDING

        binding = FragmentBillBoardBinding.inflate(inflater, container, false)

        // RETORNAR EL BINDING.ROOT

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.actionNavToCreateMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billBoardFragment_to_createMovieFragment)
        }

        binding.actionCardViewToDescription.setOnClickListener{
            it.findNavController().navigate(R.id.action_billBoardFragment_to_movieFragment)
        }
    }

}
