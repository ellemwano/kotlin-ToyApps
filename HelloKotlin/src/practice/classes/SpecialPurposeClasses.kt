package practice.classes

// Class that can only be instantiated once (singleton pattern)
object MobyDickWhale {
    val author = "Herman Melville"

    fun jump() {
        // ...
    }
}


// Enum
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}


// Sealed
sealed class Seal

class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when (seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
        // if no match, compiler error
    }
}