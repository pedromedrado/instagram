package com.example.instagram1.login

import androidx.annotation.StringRes
import common.view.base.BasePresenter
import common.view.base.BaseView

interface Login {

    interface Presenter : BasePresenter{

        fun login (email:String, password:String)

    }


    // Camada de view
    interface View : BaseView <Presenter>{

        fun showProgress(enabled:Boolean)
        fun displayEmailFailure(@StringRes emailError:Int?)
        fun displayPasswordFailure(@StringRes passwordError:Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message:String)


    }

}