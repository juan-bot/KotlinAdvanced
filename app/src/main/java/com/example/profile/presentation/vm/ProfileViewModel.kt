package com.example.profile.presentation.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profile.data.local.room.DataBase
import com.example.profile.data.local.room.entity.UserRegister
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    val stateresponse: MutableLiveData<UserRegister> = MutableLiveData()
    fun getProfile(context: Context) {
        viewModelScope.launch {
            val database = DataBase(context).getDB()
            val response = database.daoUser().getUsers()
            stateresponse.postValue(response)
        }
    }
}
