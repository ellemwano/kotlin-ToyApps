package practice.classes.spices


fun main() {
    val curry = Curry("hot curry", "very spicy")
    println("The ${curry.name} colour is: ${curry.color}")
}

//abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {
//    abstract fun prepareSpice()
//}

// Making Spice a sealed class helps keep all the spices together in one file.
sealed class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {
    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String, color: SpiceColor = YellowSpiceColor) :
    Spice(name, spiciness, color), Grinder {

    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
//    val color: String
    val color: Color  // Using enum
}

object YellowSpiceColor : SpiceColor {
//    override val color = "yellow"
    override  val color = Color.YELLOW  // Using enum
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}