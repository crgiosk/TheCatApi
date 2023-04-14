package com.catsapi.data.network

import com.catsapi.data.models.CatbreedResponse
import retrofit2.Response
import retrofit2.http.GET

interface CatbreedApiClient {

    @GET("/v1/breeds")
    suspend fun getBreeds(): Response<List<CatbreedResponse>>
}