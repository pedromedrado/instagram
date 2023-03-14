package Register.view.data

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Handler
import android.os.Looper
import common.view.model.Database
import common.view.model.UserAuth
import java.util.*

class FakeRegisterDataSource : RegisterDataSource {
    override fun create(email: String, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

       val userAuth = Database.userAuth.firstOrNull { email == it.email }

            if (userAuth == null){
                callback.onSuccess()
            }else{
                callback.onFailure("Usuário já foi Cadastrado")
            }

            callback.onComplete()

        }, 2000)

    }

    override fun create(email: String, name: String, password: String, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = Database.userAuth.firstOrNull { email == it.email }

            if (userAuth != null){
                callback.onFailure("Usuario já cadastrado ")

            }else{
                val newUser = UserAuth(UUID.randomUUID().toString(),name,email,password)

                val created = Database.userAuth.add(newUser)

                if (created){
                    callback.onSuccess()
                }else{
                    callback.onFailure("error interno no servidor")
                }
            }




            callback.onComplete()

        }, 2000)


    }
}