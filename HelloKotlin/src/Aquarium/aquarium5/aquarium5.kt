package Aquarium.aquarium5

data class Fish(var name: String)

fun main() {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")

    with (fish.name) {  // with() is a higher order function
        println(capitalize())   // Splashy
    }

    // same as above
    // Without inline, an object is created every call to myWith
    myWith (fish.name) {
        println(capitalize())   // Splashy
    }

    // with inline, no object is created and lambda body is inlined here
    fish.name.capitalize()

    println(fish.run { name })  // splashy

    println(fish.apply {  })  // Fish(name=splashy)

    val fish2 = Fish(name="splashy").apply { name = "Sharky" }
    println(fish2.name)  // Sharky

    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 31 })   // 42
}

/*
 - block (convention name): the function definition for the operation
 - We extend the String class as we want to use myWith on a string
 - Unit: the return type of the function argument
  block is now an extension function on a String object
 */
inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}
