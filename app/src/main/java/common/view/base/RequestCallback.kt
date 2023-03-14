package common.view.base

interface RequestCallback<T> {
    fun onSucess(data: T)
    fun onFailure(message:String)
    fun onComplete()
}