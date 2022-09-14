package com.example.profile.domain.repository

import android.content.Context
import com.example.profile.data.local.room.DataBase
import com.example.profile.data.model.ProfileResponse
import com.example.profile.data.model.User
import com.example.profile.data.network.RetrofitClient

class GetInfoRepository {
    suspend fun getInf(profileRequest: String, context: Context): ProfileResponse {
        val database = DataBase(context).getDB()
        val response = database.daoUser().getUserProfile(profileRequest)
        lateinit var res: ProfileResponse
        if (response != null) {
            println("Entro a ROOM !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
            val room = User(
                "${response.name}",
                "${response.lastName}",
                "${response.secondLastName}",
                "${response.birthday}",
                "${response.email}",
                "${response.genre}",
                "${response.state}",
                "${response.phone}"
            )
            res = ProfileResponse(
                true,
                room,
                "Obtenido de room"
            )
        } else {
            res = RetrofitClient.api().getInfo(profileRequest)
        }
        return res
    }
    suspend fun validateLogin(profileRequest: String, context: Context): ProfileResponse {
        val database = DataBase(context).getDB()
        val response = database.daoUser().getUserProfile(profileRequest)
        lateinit var res: ProfileResponse
        if (response != null) {
            val room = User(
                "${response.name}",
                "${response.lastName}",
                "${response.secondLastName}",
                "${response.birthday}",
                "${response.email}",
                "${response.genre}",
                "${response.state}",
                "${response.phone}"
            )
            res = ProfileResponse(
                true,
                room,
                "Obtenido de room"
            )
        } else {
            res = RetrofitClient.api().getInfo(profileRequest)
        }
        return res
    }
}
