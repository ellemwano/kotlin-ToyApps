package practice.functions

fun main() {
    println(whatShouldIDoToday())
    println(whatShouldIDoToday("happy"))
    println(whatShouldIDoToday("sad"))
}

fun whatShouldIDoToday(mood: String = getUserMood()!!, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        isHappySunny(mood, weather) -> "stay in bed"
        isHot(temperature) -> "go swimming"
        isSadRainyCold(mood, weather, temperature) -> "Stay in bed"
        isHappyWindy(mood, weather) -> "Go windsurfing"
        else -> "Stay home and read"
    }
}

fun getUserMood(): String? {
    println("What is your mood? ")
    return readLine() ?: "Happy"
}

fun isHappySunny(mood: String, weather: String) =
    mood == "happy" && weather == "sunny"

fun isHot(temperature: Int) = temperature > 35

fun isSadRainyCold(mood: String, weather: String, temperature: Int) =
    mood == "sad" && weather == "rainy" && temperature == 0

fun isHappyWindy(mood: String, weather: String) = mood == "happy" && weather == "windy"