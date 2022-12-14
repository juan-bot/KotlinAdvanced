package com.example.profile.presentation.vm

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profile.LoginState
import com.example.profile.data.model.LoginRequest
import com.example.profile.domain.usecase.LoginUseCase
import com.mh.custom_alert.CustomAlert
import com.mh.custom_alert.Theme
import com.mh.custom_alert.Type
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {
    private val loginUseCase = LoginUseCase()
    private var _stateLogin: MutableLiveData<LoginState> = MutableLiveData()
    val stateLogin: LiveData<LoginState> get() = _stateLogin
    fun login(loginRequest: LoginRequest, context: Context) {

        viewModelScope.launch {
            // loginUseCase(loginRequest)
            _stateLogin.postValue(LoginState.Cargando)
            val response = loginUseCase(loginRequest, context)
            // Thread.sleep(2000)
            if (response.status) {
                _stateLogin.postValue(LoginState.Exitoso)
            } else {
                _stateLogin.postValue(LoginState.Error(response.message))
            }
        }
    }
}
