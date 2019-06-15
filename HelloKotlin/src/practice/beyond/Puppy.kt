package practice.beyond

import kotlin.random.Random

fun main() {
    tornAway()
}

class Puppy {

    fun playWithBooks(book: Book) {
        book.tornPages(Random.nextInt(25))
    }
}

fun tornAway() {
    val puppy = Puppy()
    val book = Book("Woof woof", "Snoopy", 1994)

    while (book.pages > 0) {
        puppy.playWithBooks(book)
        println("${book.pages} left in ${book.title}.")
    }
    println("Sad puppy, no more pages in ${book.title}.")
}