package practice.beyond

fun main() {

    val symptoms = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")

    symptoms.add("white fungus")
    symptoms.remove("white fungus")

    symptoms.contains("red")  // false
    symptoms.contains("red spots")  // true

    println(symptoms.subList(4, symptoms.size))   // belly up

    listOf(1, 5, 3).sum()  // 9
    listOf("a", "b", "cc").sumBy { it.length }  // 4 (sums up length of each element)


    /*
    Mapping
     */
    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")

    println(cures.get("white spots"))
    println(cures["white spots"])

    println(cures.getOrDefault("bloating", "Sorry, I don't know"))
    println(cures.getOrElse("bloating"){ "No cure for this" })

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory.remove("fish tank")



}