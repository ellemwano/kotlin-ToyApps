package practice.classes

fun main() {

    // SimpleSpice
    val simpleSpice = SimpleSpice()
    println("Name: ${simpleSpice.name} Spiciness: ${simpleSpice.heat}")

    // Spice
    val spices1 = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "spicy"),
        Spice("ginger", "mild"),
        Spice("red curry", "medium"),
        Spice("green curry", "mild"),
        Spice("hot pepper", "extremely spicy")
    )

    val spice = Spice("turmeric", "mild")
    val spicyList = spices1.filter { it.heat < 5 }
}