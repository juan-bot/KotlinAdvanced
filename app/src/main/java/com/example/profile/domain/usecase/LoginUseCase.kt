package com.example.profile.domain.usecase

import android.content.Context
import com.example.profile.data.model.LoginRequest
import com.example.profile.data.model.LoginResponse
import com.example.profile.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private var loginRepository: LoginRepository
) {

    suspend operator fun invoke(loginRequest: LoginRequest, context: Context): LoginResponse {
        return loginRepository.login(loginRequest, context)
    }
}
