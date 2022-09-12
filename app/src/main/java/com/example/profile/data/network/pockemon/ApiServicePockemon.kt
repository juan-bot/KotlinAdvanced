package com.example.profile.data.network.pockemon

import com.example.profile.data.model.ResponsePockemon
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServicePockemon {
    // https://pokeapi.com     host
    // /api/v2/pokemon/charizard? end point
    // limit=1                   parametros
    @GET("/api/v2/pokemon?")
    suspend fun getPokemon(@Query("limit") limit: Int): ResponsePockemon
}
