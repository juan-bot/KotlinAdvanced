package com.example.profile.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("name")
    val name: String,

    @SerializedName("password")
    val pass: String
)
