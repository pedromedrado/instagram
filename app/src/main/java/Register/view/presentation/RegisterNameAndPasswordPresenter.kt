package Register.view.presentation

import Register.view.RegisterEmail
import Register.view.RegisterNameAndPassword
import Register.view.data.RegisterCallback

import Register.view.data.RegisterRepository
import android.util.Patterns
import com.example.instagram1.R

class RegisterNameAndPasswordPresenter(private var view: RegisterNameAndPassword.View?, private val repository: RegisterRepository): RegisterNameAndPassword.Presenter {

    override fun create(email: String, name: String, password: String, confirm: String) {

        val isNameValid = name .length > 3
        val isPasswordValid = password.length >= 8
        val isConfirmValid = password == confirm

        if (!isNameValid) {
            view?.displayNameFailure(R.string.invalid_name)

        } else {view?.displayNameFailure(null) }


        if (!isPasswordValid) {
            view?.displayPasswordFailure(R.string.invalid_password) }

        else{view?.displayPasswordFailure(null)
        }
        if (!isConfirmValid){
            view?.displayPasswordFailure(R.string.password_not_equal)
        }else{
            view?.displayPasswordFailure(null)
        }



        if (isNameValid && isPasswordValid && isConfirmValid){
            view?.showProgress(true)

            repository.create(email,name,password, object : RegisterCallback{

                override fun onSucess (){
                    view?.OncreateSucess(name)
                }

                override fun onFailure(message: String) {
                    view?.OncreateFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            })

        }

    }



    override fun onDestroy() {
        view = null
    }
}