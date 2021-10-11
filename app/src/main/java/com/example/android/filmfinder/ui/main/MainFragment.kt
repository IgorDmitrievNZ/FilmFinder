package com.example.android.filmfinder.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.android.filmfinder.AppState
import com.example.android.filmfinder.databinding.MainFragmentBinding
import com.example.android.filmfinder.model.entities.MovieFinder
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycle.addObserver(viewModel)

        val observer = Observer<AppState> { renderData(it) }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getMovie()
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                val movieData = appState.movieData
                progressBar.visibility = View.GONE
                filmGroup.visibility = View.VISIBLE
                setData(movieData)
            }
            is AppState.Loading -> {
                filmGroup.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                progressBar.visibility = View.GONE
                filmGroup.visibility = View.INVISIBLE
                Snackbar
                    .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getMovie() }
                    .show()
            }
        }
    }

    private fun setData(movieData: MovieFinder) = with(binding) {
        movieTitle.text = movieData.movie.title
        movieYear.text = movieData.movie.yearProduce.toString()
        movieRating.text = movieData.movie.rating.toString()
        moviePlot.text = movieData.plot
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}