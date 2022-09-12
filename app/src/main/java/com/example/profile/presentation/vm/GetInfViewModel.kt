package com.example.profile.presentation.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profile.data.local.room.DataBase
import com.example.profile.data.local.room.entity.UserRegister
import com.example.profile.data.model.ProfileResponse
import com.example.profile.domain.usecase.GetInfoUseCase
import kotlinx.coroutines.launch

class GetInfViewModel : ViewModel() {
    private val getInfoUseCase = GetInfoUseCase()
    var stateInfo: MutableLiveData<ProfileResponse> = MutableLiveData()
    fun getInfo(profileRequest: String, pass: String, context: Context) {
        viewModelScope.launch {
            val response = getInfoUseCase(profileRequest, context)
            stateInfo.postValue(response)
            val database = DataBase(context).getDB()
            database.daoUser().deleteUser()
            database.daoUser().insertUser(
                UserRegister(
                    "$profileRequest",
                    "${response.user.name}",
                    "${response.user.lastName}",
                    "${response.user.secondLastName}",
                    "${response.user.birthday}",
                    "${response.user.email}",
                    "${response.user.genre}",
                    "${response.user.state}",
                    "${response.user.phone}",
                    "$pass"
                )
            )
        }
    }
}
