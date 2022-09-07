package com.example.profile.domain.usecase

import com.example.profile.data.model.LoginRequest
import com.example.profile.data.model.LoginResponse
import com.example.profile.domain.repository.LoginRepository

class LoginUseCase {
    private var loginRepository = LoginRepository()
    suspend operator fun invoke(loginRequest: LoginRequest): LoginResponse {
        return loginRepository.login(loginRequest)
    }
}
