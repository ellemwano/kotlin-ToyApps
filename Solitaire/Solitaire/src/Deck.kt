/**
 * The deck of cards to pick from
 */

class Deck {    /*
    Array - Creates a new array with the specified size, where each element is calculated by calling the specified
    init function. The init function returns an array element given its index.
    */
    val cards = Array(52) { Card(it % 13, getSuit(it))}
    /* MutableList - A generic ordered collection of elements that supports adding and removing elements.
      toMutableList() - Returns a MutableList filled with all elements of this array.
    */
    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    /**
     * Draw a card
     */
    // removeAt() - Removes an element at the specified index from the list and returns it
    fun drawCard(): Card = cardsInDeck.removeAt(0)

    /**
     * Shuffle the deck
     */
    fun reset() {
        // We make sure we have all 52 cards before shuffling the deck
        cardsInDeck = cards.toMutableList()
        cardsInDeck.forEach { it.faceUp = false }  // all face down
        cardsInDeck.shuffle()
    }

    private fun getSuit(i: Int) = when (i / 13) {
            0 -> clubs
            1 -> diamonds
            2 -> hearts
            else -> spades
    }
}



    // value = index % 13  (as 13 cards of each suit) Will give 4 sets of 0-12
    // suit is split out based on index / 13  (result = an Int: 0-3)
        //    val cards: Array<Card> = Array(52, fun (i: Int): Card {
        //        return Card(i % 13, getSuit(i))
        //    })