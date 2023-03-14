package com.example.instagram1.profile.view.data

import Register.view.data.RegisterCallback
import com.example.instagram1.profile.view.data.presenter.ProfileDataSourceFactory
import common.view.Post
import common.view.base.RequestCallback
import common.view.model.UserAuth

class ProfileRepository(private val dataSourceFactory: ProfileDataSourceFactory) {

    fun fetchUserProfile( callback: RequestCallback<UserAuth>) {

        val localDataSource = dataSourceFactory.createLocalDataSource()
        val userAuth = localDataSource.fetchSession()
        val dataSource = dataSourceFactory.createFromUser()
        dataSource.fetchUserProfile( userAuth.uuid,object : RequestCallback<UserAuth>{

            override fun onSucess(data: UserAuth) {
                localDataSource.putUser(data)
                callback.onSucess(data)
            }

            override fun onFailure(message: String) {
                callback.onFailure(message)
            }

            override fun onComplete() {
                callback.onComplete()
            }

        })
    }

    fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {
//        dataSource.fetchUserPosts(userUUID, callback)
    }

}

