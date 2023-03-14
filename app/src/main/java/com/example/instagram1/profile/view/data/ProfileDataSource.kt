package com.example.instagram1.profile.view.data

import Register.view.data.RegisterCallback
import common.view.Post
import common.view.base.RequestCallback
import common.view.model.UserAuth
import java.util.*

interface ProfileDataSource {

    fun  fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>)
    fun  fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>)
    fun fetchSession(): UserAuth {throw UnsupportedOperationException()}
    fun putUser (response: UserAuth){throw UnsupportedOperationException()}





}