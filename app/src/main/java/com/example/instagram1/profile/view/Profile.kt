package com.example.instagram1.profile.view

import common.view.Post
import common.view.base.BasePresenter
import common.view.base.BaseView
import common.view.model.UserAuth

interface Profile {


    interface Presenter : BasePresenter {
        fun fetchUserProfile()
        fun fetchUserPosts()
    }


    interface View : BaseView<Presenter> {
        fun ShowProgress(enabled: Boolean)
        fun displayUserProfile(userAuth: UserAuth)
        fun displayEmptyPosts()
        fun displayFullPosts(posts: List<Post>)
        fun displayRequestFailure(message: String)


    }


}