package com.example.profile.domain.usecase
import com.example.profile.data.model.ProfileRequest
import com.example.profile.data.model.ProfileResponse
import com.example.profile.domain.repository.GetInfoRepository

class GetInfoUseCase {
    private var getInfoRepository = GetInfoRepository()
    suspend operator fun invoke(profileRequest: String): ProfileResponse {
        return getInfoRepository.getInf(profileRequest)
    }
}
