package com.embedded.treinamento.kotlindaggermvp.data.remote.services

import com.embedded.treinamento.kotlindaggermvp.data.model.AuthModel
import com.embedded.treinamento.kotlindaggermvp.data.remote.ApiContansts
import com.embedded.treinamento.kotlindaggermvp.data.remote.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST(ApiContansts.AUTH_API)
    fun login(@Body request: AuthModel): Call<LoginResponse>
}