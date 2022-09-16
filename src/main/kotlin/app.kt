fun main(args: Array<String>) {

    val imad = User(1488, "imad", 22, Type.FULL)
    val slavik = User(10, "slavik", 22, Type.DEMO)
    val den = User(228, "den", 22, Type.DEMO)
    val ravil = User(2111, "ravil", 24, Type.FULL)
    val nasty = User(10, "nasty", 14, Type.FULL)
    val natasha = User(500, "natasha", 22, Type.DEMO)

    println(imad.startTime())
    Thread.sleep(1000)
    println(imad.startTime())

    val listOfUser = mutableListOf(imad).apply {
        add(slavik)
        add(den)
        add(ravil)
        add(nasty)
        add(natasha)
    }
    println(listOfUser.map(User::type))


    var listOfUserFull = mutableListOf<User>()
    listOfUserFull = listOfUser.filter { it.type == Type.FULL } as MutableList<User>
    println(listOfUserFull.map(User::name))

    println(listOfUser.map(User::name).elementAt(0))
    println(listOfUser.map(User::name).elementAt(listOfUser.size - 1))

    natasha.nuiche()

    val authef = object : AuthCallback {
        override fun authSuccess() {
            println("authorization successful")
        }

        override fun authFailed() {
            println("authorization failed")
        }

    }

    fun updateCache() {
        println("Cache updated ")
    }

    auth(::updateCache) {
        if (imad.nuiche())
            authef.authSuccess()
        else
            authef.authFailed()
    }
    Action.Login(slavik)
}

inline fun auth(aut: () -> Unit, function: () -> Unit) {
    aut()
}

fun doAction(a: Action) {
    val reg = Action.Registration()
    val logout = Action.Logout()
    val login = Action.Login(User(17, "vasya", 18, Type.FULL))
    when (a) {
        reg -> println("Registration")
        logout -> println("Logout")
        else -> println("Login")// в последнем пункте Для действия `Login` вызывать метод `auth` нихуя не понял как и я забеался можешь пока посмотреть че есть
    }
}
