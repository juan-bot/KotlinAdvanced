package com.example.profile
// clase sellada con sealed
enum class TypeError {
    USUARIO_CONTRASEÑA,
    INTERNET,
    SERVER
}
data class CustomError(
    val mensaje: String,
    val code: Int,
    val type: TypeError
)
sealed class LoginState {
    object Cargando : LoginState()
    object Exitoso : LoginState()
    data class Error(val mensaje: String) : LoginState()
}
