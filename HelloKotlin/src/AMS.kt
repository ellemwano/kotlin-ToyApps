import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")
    feedTheFish()

    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }

    // repeat (function from standard library)
    repeat(2) {
        println("A fish is swimming")
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println(shouldChangeWater(day, 20, 50))
    println(shouldChangeWater(day))
    println(shouldChangeWater(day, dirty = 50))
    println(shouldChangeWater(day = "Monday"))
    eagerExample()
    lambdaExample()
    dirtyProcessor()
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random.nextInt(7)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun shouldChangeWater(
        day: String,
        temperature: Int = 22,  // in Celcius
        dirty: Int = getDirtySensorReading()): Boolean {

    return  when {  // no argument - successive if..else
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun getDirtySensorReading() = 20   // percentage - default value

fun eagerExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    val eager = decorations.filter { it[0] == 'p' }
    println(eager)

    // apply filter as sequence
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    // apply map lazily
    val lazyMap = decorations.asSequence().map {
        println("map: $it")
        it
    }
    println(lazyMap)   // print all elements
    println("first: ${lazyMap.first()}")   // print first element
    println("first: ${lazyMap.toList()}")   // print all elements
}

// Lambdas

fun lambdaExample() {
    val dirty = 20
    val waterFilter = { dirty:Int -> dirty / 2 }
    println(waterFilter(dirty))
}

var dirty = 20
val waterFilter:(Int) -> Int = { dirty -> dirty / 2 }

fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)  // :: because name function and not lambda - We're not calling it, just passing it as argument
    dirty = updateDirty(dirty) { dirty ->   // last parameter call syntax
        dirty + 50
    }
}


