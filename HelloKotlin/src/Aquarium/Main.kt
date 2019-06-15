package Aquarium

fun main() {
    buildAquarium()
    makeFish()
}

private fun buildAquarium() {

    val myAquarium = Aquarium()
    println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} " +
            "Height: ${myAquarium.height}")

    myAquarium.height = 80  // OK  as val - Same object, just modifying its properties
    println("Height: ${myAquarium.height} cm")
    println("Volume: ${myAquarium.volume} liters")

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)
    println("Small aquarium: ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish = 9)
    println("Small aquarium 2: ${myAquarium2.volume} liters with " +
            "Length: ${myAquarium2.length} " +
            "Width: ${myAquarium2.width} " +
            "Height: ${myAquarium2.height}")
}

fun feedFish(fish: FishAction) {  // fish of type FishAction
    // Only fish implementing FishAction can be passed into this function
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostonus()

    println("Shark: ${shark.color} \nPlecostonus: ${pleco.color}")

    shark.eat()
    pleco.eat()
}

