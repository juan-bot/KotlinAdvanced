package com.example.profile.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("user")
    val user: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("lastname")
    val lastName: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("phone")
    val phone: String
)
data class ProfileResponse(
    @SerializedName("status")
    val status: Boolean,

    @SerializedName("user")
    val user: User,

    @SerializedName("message")
    val message: String
)
