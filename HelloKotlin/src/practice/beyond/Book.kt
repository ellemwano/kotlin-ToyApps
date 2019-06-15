package practice.beyond

const val MAX_BOOKS = 10  // max number of borrowed books

/*
  Extension functions
 */
fun Book.getWeight(): Double = pages * 1.5

// changes the page count of the book
fun Book.tornPages(numberTorn: Int) = if (pages >= numberTorn) pages -= numberTorn else pages = 0


fun main() {
    val book = Book("The book", "the author", 2350)
//    println("Here is your book ${book.title} written by ${book. author} in ${book.year}")
    val bookTitleAuthor = book.getTitleAuthor()
    println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")
    val bookTitleAuthorYear = book.getTitleAuthorYear()
    println("Here is your book ${bookTitleAuthorYear.first} by ${bookTitleAuthorYear.second} written in ${bookTitleAuthorYear.third}")
}

class Book(val title: String, val author: String, val year: Int) {

    var pages: Int = 24

    // 2nd option (instead of Constants object) - As only used here, limit scope to this Book class
    companion object {
        const val BASE_URL = "http://www.allbooks.com/"
    }

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(numberBooks: Int): Boolean {
        return numberBooks < MAX_BOOKS
    }

    fun printUrl() {
        println(Constants.BASE_URL + title + ".html")
    }

}
