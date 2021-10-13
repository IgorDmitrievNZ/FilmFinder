package com.example.android.filmfinder.ui.list

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.filmfinder.AppState
import com.example.android.filmfinder.model.repository.Repository

class MovieListViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {

    private val liveData = MutableLiveData<AppState>()

    fun getLiveData(): LiveData<AppState> = liveData

    fun getMovie() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveData.value = AppState.Loading
        Thread {
            Thread.sleep(2000)
            liveData.postValue(AppState.Success(repository.getMoviesFromLocalStorage()))
        }.start()
    }
}