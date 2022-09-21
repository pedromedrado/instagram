package common.view.extesions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity

 fun Activity.animationEnd(callback: ()-> Unit): AnimatorListenerAdapter {
    return object : AnimatorListenerAdapter(){

        override fun onAnimationEnd(animation: Animator?) {
            super.onAnimationEnd(animation)
            callback.invoke()
        }

    }
}