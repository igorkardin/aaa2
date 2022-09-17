fun main(args: Array<String>) {

    val imad = User(1488, "imad", 22, Type.FULL)
    val slavik = User(10, "slavik", 22, Type.DEMO)
    val den = User(228, "den", 22, Type.DEMO)
    val ravil = User(2111, "ravil", 24, Type.FULL)
    val nasty = User(10, "nasty", 14, Type.FULL)
    val natasha = User(500, "natasha", 22, Type.DEMO)

    println(imad.startTime)
    Thread.sleep(1000)
    println(imad.startTime)

    val listOfUser = mutableListOf(imad).apply {
        add(slavik)
        add(den)
        add(ravil)
        add(nasty)
        add(natasha)
    }
    println(listOfUser.map(User::type))

    val listOfUserFull = listOfUser.filter { it.type == Type.FULL }
    println(listOfUserFull.map(User::name))

    println(listOfUser[0].name)
    println(listOfUser[(listOfUser.size - 1)].name)

    natasha.nuiche()

    val authef = object : AuthCallback {
        override fun authSuccess() {
            println("authorization successful")
        }

        override fun authFailed() {
            println("authorization failed")
        }
    }
}

fun updateCache() {
    println("Cache updated ")
}

inline fun auth(user: User, callback: AuthCallback, updateCache: () -> Unit) {
    if (user.age >= 18) {
        callback.authSuccess()
        updateCache()
    } else
        callback.authFailed()
}

fun doAction(a: Action, cb: AuthCallback) = when (a) {
    is Action.Registration -> println("Registration")
    is Action.Logout -> println("Logout")
    is Action.Login -> auth(user = a.lg, callback = cb, updateCache = { updateCache() })
}


