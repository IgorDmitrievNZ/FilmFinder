package com.example.android.filmfinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.filmfinder.ui.list.MovieListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieListFragment.newInstance())
                .commitNow()
        }
    }
}