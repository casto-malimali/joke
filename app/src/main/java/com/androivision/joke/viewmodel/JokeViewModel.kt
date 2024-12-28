package com.androivision.joke.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.androivision.joke.data.model.JokeResponse
import com.androivision.joke.data.repository.JokeRepository

class JokeViewModel : ViewModel() {
    private val repository = JokeRepository()
    private val _joke = MutableLiveData<JokeResponse>()
    val joke: LiveData<JokeResponse> get() = _joke

    fun getJoke() {
        viewModelScope.launch {
            try {
                _joke.value = repository.fetchJoke()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}