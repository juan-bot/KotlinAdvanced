package com.example.profile.presentation.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profile.data.model.ProfileResponse
import com.example.profile.domain.usecase.GetInfoUseCase
import kotlinx.coroutines.launch

class GetInfViewModel : ViewModel() {
    private val getInfoUseCase = GetInfoUseCase()
    var stateInfo: MutableLiveData<ProfileResponse> = MutableLiveData()
    fun getInfo(profileRequest: String) {
        viewModelScope.launch {
            val response = getInfoUseCase(profileRequest)
            stateInfo.postValue(response)
        }
    }
}
