package com.example.profile.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profile.RegisterState
import com.example.profile.data.model.RegisterRequest
import com.example.profile.domain.usecase.RegisterUseCase
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val registerUseCase = RegisterUseCase()
    private var _stateRegister: MutableLiveData<RegisterState> = MutableLiveData()
    val stateRegister: LiveData<RegisterState> get() = _stateRegister
    fun register(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            _stateRegister.postValue(RegisterState.Cargando)
            val response = registerUseCase(registerRequest)
            println("${registerRequest.name}")
            println("${registerRequest.passwor}")
            Thread.sleep(2000)
            if (response.status) {
                _stateRegister.postValue(RegisterState.Exitoso)
            } else {
                _stateRegister.postValue(RegisterState.Error(response.message))
            }
        }
    }
}
