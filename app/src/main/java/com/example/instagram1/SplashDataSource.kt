package com.example.instagram1

import Register.view.data.RegisterCallback
import com.example.instagram1.splash.data.SplashCallback

interface SplashDataSource {

    fun session(callback: SplashCallback) {
    }
}