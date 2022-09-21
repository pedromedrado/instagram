package com.example.instagram1.login.data

import common.view.model.UserAuth

interface LoginCallback {


    fun onSucess(userAuth: UserAuth)
    fun onFailure(message:String)
    fun onComplete()
}