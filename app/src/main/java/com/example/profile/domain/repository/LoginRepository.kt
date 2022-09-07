package com.example.profile.domain.repository

import com.example.profile.data.model.LoginRequest
import com.example.profile.data.model.LoginResponse

class LoginRepository {
    var wifi = true
    fun login(loginRequest: LoginRequest): LoginResponse {
        return if (wifi) {
            LoginResponse(
                status = true,
                message = "Success desde api"
            )
        } else {
            LoginResponse(
                status = true,
                message = "Success desde room"
            )
        }
    }
}
