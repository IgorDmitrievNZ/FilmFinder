package com.example.android.filmfinder.ui.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.example.android.filmfinder.databinding.FragmentSettingsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val SWITCH_KEY = "SWITCH_KEY"

class SettingsFragment : Fragment() {

    private val viewModel: SettingsViewModel by viewModel()
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private var switchCompat: SwitchCompat? = null
    private var isDataSetAdult: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            switchCompat = adultContentSwitch
            loadDataSet()
            switchCompat?.isChecked = isDataSetAdult
            switchCompat?.setOnClickListener { changeAdultDataSet() }
        }
    }


    private fun changeAdultDataSet() = with(binding) {
        isDataSetAdult = !isDataSetAdult
        saveDataSetToDisk()
    }

    private fun saveDataSetToDisk() {
        val editor = activity?.getPreferences(Context.MODE_PRIVATE)?.edit()
        editor?.putBoolean(SWITCH_KEY, isDataSetAdult)
        editor?.apply()
    }

    private fun loadDataSet() {
        activity?.let {
            isDataSetAdult = activity
                ?.getPreferences(Context.MODE_PRIVATE)
                ?.getBoolean(SWITCH_KEY, false) ?: false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = SettingsFragment()
    }

}