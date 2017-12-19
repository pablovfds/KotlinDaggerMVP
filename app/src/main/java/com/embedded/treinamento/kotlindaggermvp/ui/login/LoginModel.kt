package com.embedded.treinamento.kotlindaggermvp.ui.login

import com.embedded.treinamento.kotlindaggermvp.data.model.AuthModel
import com.embedded.treinamento.kotlindaggermvp.data.remote.ApiManager
import com.embedded.treinamento.kotlindaggermvp.data.remote.model.LoginResponse
import com.embedded.treinamento.kotlindaggermvp.data.remote.services.AuthService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModel: LoginContract.Model {

    private val authService: AuthService = ApiManager.createService(AuthService::class.java)

    override fun login(username: String, password: String, listener: LoginContract.Model.LoginListener) {
        val call = authService.login(AuthModel(username, password))
        call.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>?, t: Throwable) {

                listener.onFailure(t.message)
            }

            override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    listener.onSuccess(response.body().user.name)
                } else {
                    listener.onFailure(response.errorBody().string())
                }
            }

        })
    }
}