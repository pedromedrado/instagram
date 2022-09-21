package Register.view

import androidx.annotation.StringRes
import common.view.base.BasePresenter
import common.view.base.BaseView

interface RegisterEmail {
    interface Presenter : BasePresenter {
        fun create(email: String)

    }

    interface View : BaseView<Presenter> {
        fun showProgress (enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun onEmailFailure(message: String)
        fun goToNameAndPasswordScreen(email: String)

    }


}