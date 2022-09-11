package com.example.profile.domain.repository

import com.example.profile.data.model.LoginRequest
import com.example.profile.data.model.LoginResponse
import com.example.profile.data.network.RetrofitClient

class LoginRepository {
    var wifi = true
    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return RetrofitClient.api().login(loginRequest)
    }
}
