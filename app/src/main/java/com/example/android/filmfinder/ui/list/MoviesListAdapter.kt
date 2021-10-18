package com.example.android.filmfinder.ui.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.filmfinder.databinding.ItemFilmListBinding
import com.example.android.filmfinder.model.entities.MovieFinder

class MoviesListAdapter(private val itemClickListener: MovieListFragment.OnItemViewClickListener) :
    RecyclerView.Adapter<MoviesListAdapter.MoviesListViewHolder>() {

    private var movieData: List<MovieFinder> = listOf()
    private lateinit var binding: ItemFilmListBinding

    @SuppressLint("NotifyDataSetChanged")
    fun setMovie(data: List<MovieFinder>) {
        movieData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        binding = ItemFilmListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MoviesListViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.bind(movieData[position])
    }

    override fun getItemCount() = movieData.size

    inner class MoviesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(findMovie: MovieFinder) = with(binding) {
            movieTitle.text = findMovie.movie.title
            movieRating.text = findMovie.movie.rating.toString()
            movieYear.text = findMovie.movie.yearProduce.toString()
            root.setOnClickListener { itemClickListener.onItemViewClick(findMovie) }
        }
    }
}