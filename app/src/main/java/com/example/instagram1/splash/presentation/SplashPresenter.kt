package com.example.instagram1.splash.presentation

import com.example.instagram1.splash.Splash
import com.example.instagram1.splash.data.SplashCallback
import com.example.instagram1.splash.data.SplashRepository

class SplashPresenter(private var view: Splash.View?, private val repository: SplashRepository) :
    Splash.Presenter {

    override fun authenticated() {
        repository.session(object : SplashCallback {
            override fun onSucess() {
                view?.goToMainScreen()
            }

            override fun onFailure() {
                view?.goToLoginScreen()
            }
        })
    }


    override fun onDestroy() {
        view = null
    }


}