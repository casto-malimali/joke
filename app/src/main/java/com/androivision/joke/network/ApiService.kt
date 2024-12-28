package com.androivision.joke.network

import com.androivision.joke.data.model.JokeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("Any")
    suspend fun getJoke(): JokeResponse
}