package com.example.profile.domain.usecase
import android.content.Context
import com.example.profile.data.model.ProfileResponse
import com.example.profile.domain.repository.GetInfoRepository

class GetInfoUseCase {
    private var getInfoRepository = GetInfoRepository()
    suspend operator fun invoke(profileRequest: String, context: Context): ProfileResponse {
        return getInfoRepository.getInf(profileRequest, context)
    }
}
