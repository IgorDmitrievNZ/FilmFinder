package com.example.android.filmfinder.di

import com.example.android.filmfinder.model.repository.Repository
import com.example.android.filmfinder.model.repository.RepositoryImp
import com.example.android.filmfinder.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<Repository> { RepositoryImp() }

    //View models
    viewModel { MainViewModel(get()) }
}