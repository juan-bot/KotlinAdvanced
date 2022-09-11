package com.example.profile.data.network

import com.example.profile.data.model.* // ktlint-disable no-wildcard-imports
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // https://pokeapi.com     host
    // /api/v2/pokemon/charizard? end point
    // limit=1                   parametros
    @GET("/api/v2/pokemon/charizard?")
    suspend fun getPokemon(@Query("limit") limit: Int): ResponsePockemon

    @POST("/dev/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST("/dev/register")
    suspend fun register(@Body registerRequest: RegisterRequest): RegisterResponse

    @GET("/dev/info/{user}")
    suspend fun getInfo(@Path("user") user: String): ProfileResponse
}
