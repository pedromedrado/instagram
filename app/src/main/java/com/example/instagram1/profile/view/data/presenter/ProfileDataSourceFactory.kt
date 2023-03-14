package com.example.instagram1.profile.view.data.presenter

import com.example.instagram1.profile.view.data.ProfileDataSource
import com.example.instagram1.profile.view.data.ProfileFakeRemoteDataSource
import com.example.instagram1.profile.view.data.ProfileLocalDataSource
import common.view.model.UserAuth

class ProfileDataSourceFactory (
    private val profileCache : ProfileCache<UserAuth>
){

    fun createLocalDataSource() : ProfileDataSource{

        return ProfileLocalDataSource(profileCache)

    }

    fun createFromUser(): ProfileDataSource {

        if (profileCache.isCached()){
            return ProfileLocalDataSource(profileCache)
        }
        return ProfileFakeRemoteDataSource()

    }




}