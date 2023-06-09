package com.bdev.laboratorio05.ui.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bdev.laboratorio05.data.models.MovieModel
import com.bdev.laboratorio05.databinding.MovieItemsBinding

class MovieRecyclerViewAdapter(
    private val clickListener: (MovieModel) -> Unit
) : RecyclerView.Adapter<MovieRecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {

        val binding = MovieItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieRecyclerViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    override fun getItemCount(): Int = movies.size

    fun setData(moviesList: List<MovieModel>){
        movies.clear()
        movies.addAll(moviesList)
    }

    private val movies = ArrayList<MovieModel>()
}