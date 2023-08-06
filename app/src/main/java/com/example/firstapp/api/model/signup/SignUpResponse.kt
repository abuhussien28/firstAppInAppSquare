package com.example.taskappsaqurejetpack.api.model.signup


import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("data")
    val data: Data?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?
)