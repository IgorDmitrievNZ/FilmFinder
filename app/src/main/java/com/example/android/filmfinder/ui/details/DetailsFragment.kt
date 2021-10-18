package com.example.android.filmfinder.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.filmfinder.databinding.DetailsFragmentBinding
import com.example.android.filmfinder.model.entities.MovieFinder

class DetailsFragment : Fragment() {

    private var _binding: DetailsFragmentBinding? = null
    private val binding get() = _binding!!

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
                val movie = it.movie
                movieTitle.text = movie.title
                movieYear.text = movie.yearProduce.toString()
                movieRating.text = movie.rating.toString()
                moviePlot.text = it.plot
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