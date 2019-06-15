package practice

fun main() {
    staticExample()
}

//fun String.hasSpaces(): Boolean {
//    val found:Char? = this.find { it == ' ' }
//    return found != null
//}

// Simplified
fun String.hasSpaces()= find { it == ' ' } != null

fun extensionsExample() {
    "Does it have spaces?".hasSpaces()  // true
}

open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("Green", size)

// Helper function
fun AquariumPlant.isRed() = color == "Red"
//fun AquariumPlant.isBig() = size > 50   // error as size is private

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print()  // GreenLeafyPlant

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // AquariumPlant. At compile time, aquariumPlant is an AquariumPlant
}

// Extension property
val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun propertyExample() {
    val plant = AquariumPlant("Green", 50)
    plant.isGreen  // true
}

fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull()  // ok
}