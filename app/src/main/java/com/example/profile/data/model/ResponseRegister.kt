package com.example.profile.data.model

import com.google.gson.annotations.SerializedName

data class ResponseRegister(
    @SerializedName("user")
    var user: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("lastName")
    var lastName: String,

    @SerializedName("secondLastName")
    var secondLastName: String,

    @SerializedName("birthday")
    var birthday: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("gender")
    var gender: String,

    @SerializedName("state")
    var state: String,

    @SerializedName("phone")
    var phone: String,

    @SerializedName("password")
    var password: String,

    @SerializedName("civil")
    var civil: String
)
