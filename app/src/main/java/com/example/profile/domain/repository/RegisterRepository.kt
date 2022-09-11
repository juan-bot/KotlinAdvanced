package com.example.profile.domain.repository

import com.example.profile.data.model.RegisterRequest
import com.example.profile.data.model.RegisterResponse
import com.example.profile.data.network.RetrofitClient

class RegisterRepository {
    var wifi = true
    suspend fun register(registerRequest: RegisterRequest): RegisterResponse {
        return if (wifi) {
            return RetrofitClient.api().register(registerRequest)
        } else {
            RegisterResponse(
                false,
                "Connection Failed"
            )
        }
    }
}
