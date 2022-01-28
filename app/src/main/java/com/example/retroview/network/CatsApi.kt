package com.example.retroview.network

import com.example.retroview.network.models.Fact
import retrofit2.http.GET

interface CatsApi {

    @GET("/fact")
    suspend fun getFact(): Fact
}