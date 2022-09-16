fun main(args: Array<String>) {

    val imad = User(1488, "imad", 22, Type.FULL)
    val slavik = User(10, "slavik", 22, Type.DEMO)
    val den = User(228, "den", 22, Type.DEMO)
    val ravil = User(2111, "ravil", 24, Type.FULL)
    val nasty = User(10, "nasty", 22, Type.FULL)
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

    println(natasha.nuiche())

    val auth = object : AuthCallback {
        override fun authSuccess() {
            println("authorization successful")
        }

        override fun authFailed() {
            println("authorization failed")
        }

    }


    fun auth(aut: () -> Unit ) {
        aut()
    }

    fun updateCache() {
        println("Cache updated ")
    }

    auth(::updateCache)
}

