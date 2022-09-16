import java.time.LocalTime

class User(val id: Int, val name: String, val age: Int, val type: Type) {

    fun startTime(): LocalTime = LocalTime.now()

    fun nuiche(): Boolean {
        val a: Boolean
        if (age >= 18) {
            a = true
            println("Проходите, приятного отдыха")
        } else {
            a = false
            println("Зайти не получится")
        }
        return a
    }
}