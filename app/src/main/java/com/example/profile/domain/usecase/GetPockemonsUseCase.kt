package com.example.profile.domain.usecase

import com.example.profile.data.model.ResponsePockemon
import com.example.profile.domain.repository.GetPockemonsRepository

class GetPockemonsUseCase {
    private var getPockemonsRepository = GetPockemonsRepository()
    suspend operator fun invoke(limit: Int): ResponsePockemon {
        return getPockemonsRepository.getPockemons(limit)
    }
}
