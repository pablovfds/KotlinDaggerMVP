package com.embedded.treinamento.kotlindaggermvp.ui.login

import com.embedded.treinamento.kotlindaggermvp.ui.base.BaseListener
import com.embedded.treinamento.kotlindaggermvp.ui.base.BasePresenter
import com.embedded.treinamento.kotlindaggermvp.ui.base.BaseView

interface LoginContract {
    interface Model {
        interface LoginListener : BaseListener{
            fun onSuccess(accountName: String)
        }

        fun login(username: String, password: String, listener: LoginListener)
    }

    interface Presenter : BasePresenter<View> {
        fun validateCredentials(username: String, password: String)
    }

    interface View : BaseView {
        fun navigateToHome(accountName: String)
    }

}