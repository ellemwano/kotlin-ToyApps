package practice.classes


fun main() {
    delegate()
}

fun delegate() {
    val pleco = Plecostonus2()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

// Delegation, using "by" keyword
class Plecostonus2(fishColor: FishColor = GoldColor) :  // Gold by default
    FishAction by PrintingFishAction("a lot of algae"),
    FishColor by GoldColor {
    // No longer needed after PrintingFishAction delegation
//    override fun eat() {
//        println("eat algae")
//    }
    // No longer needed after GoldColor delegation
//    override val color: String
//            get() = "gold"
}

// Delegation to an object which knows how to provide a fish colour
object GoldColor : FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val  color = "red"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}


