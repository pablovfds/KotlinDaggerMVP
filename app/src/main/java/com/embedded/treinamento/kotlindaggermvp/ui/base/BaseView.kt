package com.embedded.treinamento.kotlindaggermvp.ui.base

interface BaseView {
    fun showError(error: String)
    fun showProgressBar()
    fun hideProgressBar()
}