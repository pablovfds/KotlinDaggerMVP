package com.embedded.treinamento.kotlindaggermvp.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.embedded.treinamento.kotlindaggermvp.R
import com.embedded.treinamento.kotlindaggermvp.ui.home.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View, View.OnClickListener {

    private var mLoginPresenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSignIn.setOnClickListener(this)
        this.mLoginPresenter =  LoginPresenter(LoginModel())
    }

    override fun onStart() {
        super.onStart()
        this.mLoginPresenter?.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        this.mLoginPresenter?.detachView()
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btnSignIn) {
            this.mLoginPresenter?.validateCredentials(edtUsername.text.toString(),
                    edtPassword.text.toString())
        }
    }

    override fun navigateToHome(accountName: String) {
        Toast.makeText(this, "Bem vindo " + accountName, Toast.LENGTH_LONG).show()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showProgressBar() {
        pbSignIn.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        pbSignIn.visibility = View.GONE
    }
}
