package com.bdev.laboratorio05.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.bdev.laboratorio05.data.models.MovieModel
import com.bdev.laboratorio05.databinding.MovieItemsBinding

class MovieRecyclerViewHolder(private val binding: MovieItemsBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {

        binding.tittleTextView.text = movie.name
        binding.qualificationTextView.text= movie.qualification

        binding.actionCardViewToDescription.setOnClickListener{
            clickListener(movie)
        }
    }


}