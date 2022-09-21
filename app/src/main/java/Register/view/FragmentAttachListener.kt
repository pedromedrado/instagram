package Register.view

interface FragmentAttachListener {
    fun goToNameAndPassword(email:String)
    fun goToWelcomeScreen(name:String)
    fun goToPhotoScreen()
    fun goToMainScreen()
    fun goToGalleryScreen()
    fun goToCameraScreen()

}