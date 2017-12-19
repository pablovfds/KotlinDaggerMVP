package com.embedded.treinamento.kotlindaggermvp.ui.base

interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}