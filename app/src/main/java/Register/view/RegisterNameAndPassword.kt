package Register.view

import androidx.annotation.StringRes
import common.view.base.BasePresenter
import common.view.base.BaseView

interface RegisterNameAndPassword {
    interface Presenter : BasePresenter {
        fun create(email:String, name:String, password:String, confirm: String)

    }

    interface View : BaseView<Presenter> {
        fun showProgress (enabled: Boolean)
        fun displayNameFailure(@StringRes nameError: Int?)
        fun displayPasswordFailure(@StringRes passwordError: Int?)
        fun OncreateFailure(message: String)
        fun OncreateSucess(name: String)

    }
}