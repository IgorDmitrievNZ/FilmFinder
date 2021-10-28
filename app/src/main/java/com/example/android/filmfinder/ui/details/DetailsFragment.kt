package com.example.android.filmfinder.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.android.filmfinder.AppState
import com.example.android.filmfinder.databinding.DetailsFragmentBinding
import com.example.android.filmfinder.model.entities.MovieFinder
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private var _binding: DetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<MovieFinder>(BUNDLE_EXTRA)?.let {
            with(binding) {

                viewModel.liveDataToObserve.observe(viewLifecycleOwner, { appState ->
                    when (appState) {
                        is AppState.Error -> {
                            mainView.visibility = View.INVISIBLE
                            progressBar.visibility = View.GONE
                            errorTV.visibility = View.VISIBLE
                        }
                        AppState.Loading -> {
                            mainView.visibility = View.INVISIBLE
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        is AppState.Success -> {
                            progressBar.visibility = View.GONE
                            mainView.visibility = View.VISIBLE
                            movieTitle.text = appState.movieData[0].title
                            movieYear.text = appState.movieData[0].year.toString()
                            movieRating.text = appState.movieData[0].rating.toString()
                            moviePlot.text = appState.movieData[0].plot
                            movieImage.load(appState.movieData[0].poster)
                        }
                    }
                })
                viewModel.loadData(it.movie.id)
            }
        }
    }

    companion object {

        const val BUNDLE_EXTRA = "movies"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}