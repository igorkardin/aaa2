import java.time.LocalTime

class User(val id: Int, val name: String, val age: Int, val type: Type) {

    val startTime: LocalTime by lazy { LocalTime.now() }

}

fun User.nuiche(){
    if (age >= 18) {
        println("Проходите, приятного отдыха")
    } else {
        throw IllegalStateException("Без объяснения причины")
    }
}