package com.androivision.joke.data.repository

import com.androivision.joke.network.RetrofitClient

class JokeRepository {
        private val apiService = RetrofitClient.apiService

        suspend fun fetchJoke() = apiService.getJoke()    }






