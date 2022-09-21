package Register.view.data

import Register.view.RegisterEmail
import javax.security.auth.callback.Callback

interface RegisterDataSource {
    fun create(email: String, callback: RegisterCallback)
    fun create(email: String, name:String, password:String, callback: RegisterCallback)
}