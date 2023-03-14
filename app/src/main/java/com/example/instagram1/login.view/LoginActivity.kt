package com.example.instagram1.login.view

import Register.view.RegisterActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.instagram1.R
import com.example.instagram1.databinding.ActivityLoginBinding
import com.example.instagram1.login.Login
import com.example.instagram1.login.LoginPresenter
import com.example.instagram1.login.data.FakeDataSource
import com.example.instagram1.login.data.LoginRepository
import com.example.instagram1.main.view.MainActivity
import com.google.android.material.textfield.TextInputEditText
import common.view.base.DependencyInjector
import common.view.util.TxtWatcher

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding: ActivityLoginBinding

    //iniciação do presenter passando interface e os dados que quer passar
    override lateinit var presenter: Login.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        presenter = LoginPresenter(this, DependencyInjector.loginRepository())


        with(binding) {

            loginEditEmail.addTextChangedListener(watcher)
            //apaga o campo apos o erro do usuario ao colocar  usuario
            loginEditEmail.addTextChangedListener(TxtWatcher{displayEmailFailure(null)})
            loginEditPassword.addTextChangedListener(watcher)
            loginEditPassword.addTextChangedListener(TxtWatcher{displayEmailFailure(null)})



            btnEnter.setOnClickListener() {
                //referencia de dentro da interface
                presenter.login(loginEditEmail.text.toString(), loginEditPassword.text.toString())
            }
            loginTxtRegister.setOnClickListener{
                goToRegisterScreen()
            }

        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
    private val watcher = TxtWatcher {
        binding.btnEnter.isEnabled = binding.loginEditEmail.text.toString().isNotEmpty()&&
                binding.loginEditPassword.text.toString().isNotEmpty()

    }

    private fun goToRegisterScreen(){
        startActivity(Intent(this,RegisterActivity::class.java))
    }

    override fun showProgress(enabled: Boolean) {
        binding.btnEnter.showProgress(enabled)
    }

    override fun displayEmailFailure(emailError: Int?) {

        binding.loginEmailInput.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.loginPasswordInput.error = passwordError?.let { getString(it) }
    }


    override fun onUserAuthenticated() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun onUserUnauthorized(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}