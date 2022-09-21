package com.example.instagram1.splash.data

import com.example.instagram1.SplashDataSource
import common.view.model.Database

class FakeLocalDataSource: SplashDataSource {

    override fun session(callback: SplashCallback) {

        if (Database.sessionAuth != null){
            callback.onSucess()
        }else{
            callback.onFailure()
        }
    }
}