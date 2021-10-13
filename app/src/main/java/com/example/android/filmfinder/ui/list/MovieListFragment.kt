package com.example.android.filmfinder.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.filmfinder.AppState
import com.example.android.filmfinder.R
import com.example.android.filmfinder.databinding.FragmentRecyclerListBinding
import com.example.android.filmfinder.model.entities.MovieFinder
import com.example.android.filmfinder.ui.details.DetailsFragment
import com.google.android.material.snackbar.Snackbar

import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : Fragment() {

    private val viewModel: MovieListViewModel by viewModel()

    private var _binding: FragmentRecyclerListBinding? = null
    private val binding get() = _binding!!

    private var adapter: MoviesListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            moviesListRecycler.adapter = adapter
            viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
            viewModel.getMovieFromLocalSource()
        }
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                progressBar.visibility = View.GONE
                adapter = MoviesListAdapter(object : OnItemViewClickListener {
                    override fun onItemViewClick(movies: MovieFinder) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager ->
                            val bundle = Bundle().apply {
                                putParcelable(DetailsFragment.BUNDLE_EXTRA, movies)
                            }
                            manager.beginTransaction()
                                .add(R.id.container, DetailsFragment.newInstance(bundle))
                                .addToBackStack("")
                                .commitAllowingStateLoss()
                        }
                    }
                }).apply {
                    setMovie(appState.movieData)
                }
                moviesListRecycler.adapter = adapter
            }
            is AppState.Loading -> {
                progressBar.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                progressBar.visibility = View.GONE
                Snackbar
                    .make(
                        binding.progressBar,
                        getString(R.string.error),
                        Snackbar.LENGTH_INDEFINITE
                    )
                    .setAction(getString(R.string.reload)) { viewModel.getMovieFromLocalSource() }
                    .show()
            }
        }
    }

    companion object {
        fun newInstance() = MovieListFragment()
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(movies: MovieFinder)
    }
}