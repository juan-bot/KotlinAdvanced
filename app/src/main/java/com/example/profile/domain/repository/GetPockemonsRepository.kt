package com.example.profile.domain.repository

import com.example.profile.data.model.ResponsePockemon
import com.example.profile.data.network.pockemon.RetrofitPockemon

class GetPockemonsRepository {
    suspend fun getPockemons(limit: Int): ResponsePockemon {
        return RetrofitPockemon.api().getPokemon(limit)
    }
}
