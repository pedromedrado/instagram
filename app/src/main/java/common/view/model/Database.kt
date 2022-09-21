package common.view.model

import java.util.*

object Database {
    val userAuth = hashSetOf<UserAuth>()
    var sessionAuth: UserAuth? = null

    init {
        userAuth.add(UserAuth(UUID.randomUUID().toString(),"UserA","userA@gmail.com","12345678"))
        userAuth.add(UserAuth(UUID.randomUUID().toString(),"UserB","userB@gmail.com","87456321"))

            sessionAuth = userAuth.first()
        
    }

}