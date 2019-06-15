package practice.functions

fun main() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

    // Filter all the curries
    val currySpices = spices.filter { it.contains("curry") }.sortedBy { it.length }
    println(currySpices)

    // spices starting with 'c' and ending with 'e' - 2 ways
    val ce1 = spices.filter { it.startsWith('c') }.filter { it.endsWith('e') }
    val ce2 = spices.filter { it.startsWith('c') && it.endsWith('e') }
    println("$ce1 $ce2")

    // Select first 3 spices and filter the ones starting with 'c'
    val firstE = spices.take(3).filter { it.startsWith('c') }
//    val firstE = spices.subList(0, 3).filter { it.startsWith('c') }
    println(firstE)
}