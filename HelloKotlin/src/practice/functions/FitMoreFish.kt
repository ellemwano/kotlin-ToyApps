package practice.functions

fun main() {
    println(canAddFish(10.0, listOf(3, 3, 3)))
    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1, 1, 3), 3))
    println(canAddFish(10.0, listOf(), 7, true))
}


fun canAddFish(
        tankSize: Double,   // in inches
        currentFish: List<Int>,
        fishSize: Int = 2, // in inches
        hasDecorations: Boolean = true): Boolean {
    return when(hasDecorations) {
        true -> currentFish.sum() + fishSize <= tankSize * 0.8
        else -> currentFish.sum() + fishSize <= tankSize
    }
}

//fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
//    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
//}