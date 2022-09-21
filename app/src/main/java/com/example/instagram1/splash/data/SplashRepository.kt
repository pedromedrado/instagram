package com.example.instagram1.splash.data

import com.example.instagram1.SplashDataSource

class SplashRepository (private val dataSource: SplashDataSource){

    fun session(callback: SplashCallback) {
        dataSource.session(callback)
    }
}