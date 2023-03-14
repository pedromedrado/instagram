package common.view.model

import common.view.Post
import java.util.*

object Database {
    val userAuth = hashSetOf<UserAuth>()
    var sessionAuth: UserAuth? = null
    val posts = hashMapOf<String, Set<Post>>()


    init {
        userAuth.add(UserAuth(UUID.randomUUID().toString(),"UserA","userA@gmail.com","12345678"))
        userAuth.add(UserAuth(UUID.randomUUID().toString(),"UserB","userB@gmail.com","87456321"))

            sessionAuth = userAuth.first()
        
    }

}