package com.example.profile.data.model

import com.google.gson.annotations.SerializedName

data class ProfileRequest(
    @SerializedName("user")
    val user: String
)
