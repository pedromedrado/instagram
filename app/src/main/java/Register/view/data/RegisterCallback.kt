package Register.view.data

import common.view.model.UserAuth

interface RegisterCallback {


    fun onSucess()
    fun onFailure(message:String)
    fun onComplete()
}