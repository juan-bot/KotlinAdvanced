package com.example.profile.data.model

import com.google.gson.annotations.SerializedName

data class DeleteResponse(
    @SerializedName("status")
    val status: Boolean,

    @SerializedName("message")
    val message: String
)
