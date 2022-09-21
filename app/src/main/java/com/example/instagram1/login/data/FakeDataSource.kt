package com.example.instagram1.login.data

import android.os.Handler
import android.os.Looper
import common.view.model.Database

class FakeDataSource : LoginDataSource {
    override fun login(email: String, password: String, callback: LoginCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

       val userAuth = Database.userAuth.firstOrNull { email == it.email }

        callback.onFailure("Usuário não encontrado")

            when {
                userAuth == null -> {
                }
                userAuth.password!= password -> {
                    callback.onFailure("Senha está incorreta")
                }
                else -> {
                    Database.sessionAuth = userAuth
                    callback.onSucess(userAuth)
                }
            }
            callback.onComplete()
        }, 2000)


    }
}