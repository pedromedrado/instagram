package com.example.instagram1.profile.view.data

import Register.view.data.RegisterCallback
import android.os.Handler
import android.os.Looper
import common.view.Post
import common.view.base.RequestCallback
import common.view.model.Database
import common.view.model.UserAuth

class ProfileFakeRemoteDataSource : ProfileDataSource {

    override fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>) {

            Handler(Looper.getMainLooper()).postDelayed({

                val userAuth = Database.userAuth.firstOrNull { userUUID == it.uuid}

                if (userAuth != null){
                    callback.onSucess(userAuth)
                }else{
                    callback.onFailure("Usuário não encontrado")
                }

                callback.onComplete()

            }, 2000)
        }

    override fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {

        Handler(Looper.getMainLooper()).postDelayed({

            val posts = Database.posts[userUUID]

            callback.onSucess(posts?.toList() ?: emptyList())

            callback.onComplete()

        }, 2000)
    }


}


