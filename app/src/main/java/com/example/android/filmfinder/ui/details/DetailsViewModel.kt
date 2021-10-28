package com.example.android.filmfinder.ui.details

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.filmfinder.AppState
import com.example.android.filmfinder.model.repository.Repository

class DetailsViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {
    val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun loadData(id: String) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            val data = repository.getMoviesFromServer(id)
            liveDataToObserve.postValue(AppState.Success(listOf(data)))
        }.start()
    }
}