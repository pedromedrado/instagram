package com.example.instagram1.profile.view.data

import com.example.instagram1.profile.view.data.presenter.ProfileCache
import common.view.Post
import common.view.base.RequestCallback
import common.view.model.Database
import common.view.model.UserAuth

class ProfileLocalDataSource(
    private val profileCache: ProfileCache<UserAuth>
) : ProfileDataSource {

    override fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>) {
        val userAuth = profileCache.get(userUUID)
        if (userAuth != null){
            callback.onSucess(userAuth)
        }else{
            callback.onFailure("Usuario não encontrado. ")
        }
        callback.onComplete()
    }

    override fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {
    }

    override fun fetchSession(): UserAuth {
        return  Database.sessionAuth ?: throw RuntimeException("Usuario não logado")
    }


    override fun putUser(response: UserAuth) {
        profileCache.put(response)
    }
}