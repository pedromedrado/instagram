package common.view.base

import Register.view.data.FakeRegisterDataSource
import Register.view.data.RegisterRepository
import com.example.instagram1.login.data.FakeDataSource
import com.example.instagram1.login.data.LoginRepository
import com.example.instagram1.profile.view.data.ProfileFakeRemoteDataSource
import com.example.instagram1.profile.view.data.ProfileMemoryCache
import com.example.instagram1.profile.view.data.ProfileRepository
import com.example.instagram1.profile.view.data.presenter.ProfileDataSourceFactory
import com.example.instagram1.splash.data.FakeLocalDataSource
import com.example.instagram1.splash.data.SplashRepository

object DependencyInjector {

    fun splashRepository(): SplashRepository {
        return SplashRepository(FakeLocalDataSource())

    }

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())


    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }

    fun profileRepository() : ProfileRepository{
        return  ProfileRepository(ProfileDataSourceFactory(ProfileMemoryCache))
    }
}
