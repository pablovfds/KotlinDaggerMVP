package com.embedded.treinamento.kotlindaggermvp.data.remote.model

import com.embedded.treinamento.kotlindaggermvp.data.model.UserModel
import com.google.gson.annotations.SerializedName

data class LoginResponse(
        @SerializedName("status")
        val status: Int,

        @SerializedName("token")
        val token: String,

        @SerializedName("user")
        val user: UserModel
)