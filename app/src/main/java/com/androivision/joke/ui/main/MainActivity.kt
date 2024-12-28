package com.androivision.joke.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.activity.viewModels
import com.androivision.joke.R
import com.androivision.joke.viewmodel.JokeViewModel

class MainActivity : AppCompatActivity() {
    private val jokeViewModel: JokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jokeTextView: TextView = findViewById(R.id.jokeTextView)

        jokeViewModel.joke.observe(this) { joke ->
            jokeTextView.text = joke.joke ?: "${joke.setup}\n${joke.delivery}"
        }

        // Fetch joke
        jokeViewModel.getJoke()
    }
}