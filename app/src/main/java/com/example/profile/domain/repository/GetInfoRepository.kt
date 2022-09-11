package com.example.profile.domain.repository

import com.example.profile.data.model.ProfileResponse
import com.example.profile.data.network.RetrofitClient

class GetInfoRepository {
    var wifi = true
    suspend fun getInf(profileRequest: String): ProfileResponse {
        return RetrofitClient.api().getInfo(profileRequest)
    }
}
