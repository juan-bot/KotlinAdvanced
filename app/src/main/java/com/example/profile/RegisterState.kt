package com.example.profile

sealed class RegisterState {
    object Cargando : RegisterState()
    object Exitoso : RegisterState()
    data class Error(val mensaje: String) : RegisterState()
}
