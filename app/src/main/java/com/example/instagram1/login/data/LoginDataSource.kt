package com.example.instagram1.login.data

import javax.security.auth.callback.Callback

interface LoginDataSource {
    fun login(email:String, password:String, callback:LoginCallback)
}