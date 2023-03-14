package com.example.instagram1.profile.view.data.presenter

import Register.view.data.RegisterCallback

import android.util.Patterns
import com.example.instagram1.R
import com.example.instagram1.profile.view.Profile
import com.example.instagram1.profile.view.data.ProfileRepository
import common.view.Post
import common.view.base.RequestCallback
import common.view.model.Database
import common.view.model.UserAuth

class ProfilePresenter(
    private var view: Profile.View?,
    private val repository: ProfileRepository
) : Profile.Presenter {


    override fun fetchUserProfile() {

        val userUUID = Database.sessionAuth?.uuid ?: throw RuntimeException("user not found")
        repository.fetchUserProfile( object : RequestCallback<UserAuth> {

            override fun onSucess(data: UserAuth) {
                view?.displayUserProfile(data)

            }

            override fun onFailure(message: String) {
                view?.displayRequestFailure(message)

            }

            override fun onComplete() {
            }


        })
    }


    override fun fetchUserPosts() {

        val userUUID = Database.sessionAuth?.uuid ?: throw RuntimeException("user not found")
        repository.fetchUserPosts(userUUID, object : RequestCallback<List<Post>> {

            override fun onSucess(data: List<Post>) {
                if (data.isEmpty()) {
                    view?.displayEmptyPosts()
                } else {
                    view?.displayFullPosts(data)

                }
            }

            override fun onFailure(message: String) {
                view?.displayRequestFailure(message)
            }

            override fun onComplete() {
                view?.ShowProgress(false)
            }


        })
    }



    override fun onDestroy() {
        view = null
    }


}



