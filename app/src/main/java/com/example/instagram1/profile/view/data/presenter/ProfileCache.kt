package com.example.instagram1.profile.view.data.presenter

import common.view.model.UserAuth

interface ProfileCache <T>{
    fun isCached() : Boolean
    fun get (key : String) : T?
    fun put(data : T)

}