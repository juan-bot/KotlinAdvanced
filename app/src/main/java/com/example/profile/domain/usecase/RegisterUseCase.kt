package com.example.profile.domain.usecase

import com.example.profile.data.model.RegisterRequest
import com.example.profile.data.model.RegisterResponse
import com.example.profile.domain.repository.RegisterRepository

class RegisterUseCase {
    private var registerRepository = RegisterRepository()
    suspend operator fun invoke(registerRequest: RegisterRequest): RegisterResponse {
        return registerRepository.register(registerRequest)
    }
}
