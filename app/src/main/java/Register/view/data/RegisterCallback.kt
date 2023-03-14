package Register.view.data

import common.view.model.UserAuth

interface RegisterCallback {

    fun onSuccess()
    fun onFailure(message:String)
    fun onComplete()
}