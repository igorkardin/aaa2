import java.time.LocalTime

class User(val id: Int, val name: String, private val age: Int, val type: Type) {

    fun startTime(): LocalTime = LocalTime.now()

    fun nuiche(): String {
        return if (age >= 18)
            "Проходите, приятного отдыха"
        else
            return "Зайти не получится"
    }
}