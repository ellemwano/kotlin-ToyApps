import org.junit.Test

import org.junit.Assert.*

class TableauPileTest {

    /**
     * Add red Queen to a tableauPile with a black King. Size should be 2
     */
    @Test
    fun addCards() {
        // arrange
        val tableauPile = TableauPile(mutableListOf(Card(12, spades)))  // King of Spades
        val cards = mutableListOf(Card(11, hearts))  // Queen of Hearts

        // act
        tableauPile.addCards(cards)

        // assert
        assertEquals(2, tableauPile.cards.size)
    }

    /**
     * Create a tableau pile of 3 cards. Remove all cards at index 1 and higher. Should return the remaining card (at index 0): 4 of clubs
     */
    @Test
    fun removeCards() {
        // arrange
        val tableauPile = TableauPile(mutableListOf(
                Card(4, clubs),
                Card(3, diamonds),
                Card(2, spades))
        )

        // act
        tableauPile.removeCards(1)

        // assert
        assertEquals(mutableListOf(Card(4, clubs, true)), tableauPile.cards)
    }
}