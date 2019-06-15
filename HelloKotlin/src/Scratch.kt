import java.util.*

fun main() {
   dayOfWeek()

//    val isUnit = println("This is an expression")
//    println(isUnit)   // prints kotlin.Unit
//
//    val temperature = 10
//    val isHot = if (temperature > 50) true else false
//    println(isHot)
//
//    val message = "You are a ${ if (temperature > 50) "fried" else "safe" } fish"
//    println(message)
}

fun dayOfWeek() {
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(when (day) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Where am I?"
    })
}
