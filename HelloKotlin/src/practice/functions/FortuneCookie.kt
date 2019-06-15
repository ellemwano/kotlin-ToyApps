package practice.functions
fun main() {
    // println("Your fortune is: ${getFortuneCookie()}")
    fortuneLoop()
}

fun getFortuneCookie(birthday: Int): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    val index = when (birthday) {
        in 1..7 -> 4
        28, 31 -> 2
        else -> birthday.rem(fortunes.size)
    }
    return fortunes[index]
}

fun fortuneLoop() {
    var fortune: String = ""
    while (! fortune.contains("Take it easy")) {
        fortune = getFortuneCookie(getBirthday())
        println("Your fortune is: $fortune")
    }
}

fun getBirthday(): Int {
    println("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}
