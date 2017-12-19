package com.embedded.treinamento.kotlindaggermvp.ui.login

import com.embedded.treinamento.kotlindaggermvp.ui.base.BasePresenterImpl

class LoginPresenter
    constructor(private val mModel: LoginModel) : BasePresenterImpl<LoginContract.View>(),
        LoginContract.Presenter, LoginContract.Model.LoginListener {

    override fun validateCredentials(username: String, password: String) {
        this.mView?.showProgressBar()
        this.mModel.login(username, password, this)
    }

    override fun onFailure(error: String?) {
        this.mView?.hideProgressBar()
        this.mView?.showError(error!!)
    }

    override fun onSuccess(accountName: String) {
        this.mView?.hideProgressBar()
        this.mView?.navigateToHome(accountName)
    }
}