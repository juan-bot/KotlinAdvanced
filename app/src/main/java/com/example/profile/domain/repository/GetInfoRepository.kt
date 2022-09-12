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
            println("room ************ $response ----------------")
            println("existee en room ")
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
            println("api ************ $res ----------------")
        }
        return res
        // return RetrofitClient.api().getInfo(profileRequest)
    }
    suspend fun getProfile(profileRequest: String, context: Context): ProfileResponse {
        val database = DataBase(context).getDB()
        val response = database.daoUser().getUsers()
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
        var res = ProfileResponse(
            true,
            room,
            "Obtenido de room"
        )
        return res
    }
}
