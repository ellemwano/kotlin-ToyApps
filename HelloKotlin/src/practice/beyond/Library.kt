package practice.beyond

fun main() {

    val allBooks = setOf<String>("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library = mapOf("William Shakespeare" to allBooks)
    println(library.any{ it.value.contains("Hamlet")})  // true

    var moreBooks = mutableMapOf("On the Road" to "Jack Kerouac")
    moreBooks.getOrPut("Hamlet") {"William Shakespeare"}
    moreBooks.getOrPut("War and Peace") {"Leon Tolstoy"}
    println(moreBooks)
}

