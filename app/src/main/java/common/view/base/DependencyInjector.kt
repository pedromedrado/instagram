package common.view.base

import Register.view.data.FakeRegisterDataSource
import Register.view.data.RegisterRepository
import com.example.instagram1.login.data.FakeDataSource
import com.example.instagram1.login.data.LoginRepository
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
}
