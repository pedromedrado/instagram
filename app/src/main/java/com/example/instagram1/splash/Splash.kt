package com.example.instagram1.splash

import common.view.base.BasePresenter
import common.view.base.BaseView


interface Splash {

    interface Presenter : BasePresenter {
        fun authenticated()

    }

    interface View : BaseView<Presenter> {
        fun goToMainScreen()
        fun goToLoginScreen()
    }

}