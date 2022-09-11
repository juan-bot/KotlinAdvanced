package com.example.profile
// clase sellada con sealed

sealed class LoginState {
    object Cargando : LoginState()
    object Exitoso : LoginState()
    data class Error(val mensaje: String) : LoginState()
}
