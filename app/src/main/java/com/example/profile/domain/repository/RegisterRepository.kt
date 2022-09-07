package com.example.profile.domain.repository

import com.example.profile.data.model.RegisterRequest
import com.example.profile.data.model.RegisterResponse

class RegisterRepository {
    var wifi = true
    fun register(registerRequest: RegisterRequest): RegisterResponse {
        return if (wifi) {
            RegisterResponse(
                status = true,
                message = "Success desde api"
            )
        } else {
            RegisterResponse(
                status = true,
                message = "Success desde room"
            )
        }
    }
}
