package com.example.profile.domain.repository

import android.content.Context
import com.example.profile.data.local.room.DataBase
import com.example.profile.data.model.LoginRequest
import com.example.profile.data.model.LoginResponse
import com.example.profile.data.network.RetrofitClient
import javax.inject.Inject

class LoginRepository @Inject constructor() {
    suspend fun login(loginRequest: LoginRequest, context: Context): LoginResponse {
        val database = DataBase(context).getDB()
        val response = database.daoUser().getUser(loginRequest.user, loginRequest.pass)
        lateinit var res: LoginResponse
        if (response != null) {
            println("existee")
            res = LoginResponse(
                true,
                "Encontrado desde room"
            )
        } else {
            res = RetrofitClient.api().login(loginRequest)
        }
        return res
    }
}
