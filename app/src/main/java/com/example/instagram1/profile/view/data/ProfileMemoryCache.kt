package com.example.instagram1.profile.view.data

import com.example.instagram1.profile.view.data.presenter.ProfileCache
import common.view.model.UserAuth

object ProfileMemoryCache : ProfileCache<UserAuth> {

    private var userAuth: UserAuth? = null

    override fun isCached(): Boolean {
        return userAuth != null
    }

    override fun get(key: String): UserAuth? {
        if (userAuth?.uuid == key){
            return userAuth
    }
    return null
}

    override fun put(data: UserAuth) {
        userAuth = data
    }
}