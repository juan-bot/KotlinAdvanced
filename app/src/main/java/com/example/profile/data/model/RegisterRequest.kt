package com.example.profile.data.model

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("user")
    val user: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("lastname")
    val lastName: String,
    @SerializedName("secondLastName")
    val secondLastName: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("password")
    val passwor: String,
    @SerializedName("civil")
    val civil: String
)
