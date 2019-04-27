/**
 * The 4 piles collecting each set of cards, for each suit, from ace to King
 */

class FoundationPile(val suit: String) {
    val cards: MutableList<Card> = mutableListOf()  // empty list

    fun reset() {
        cards.clear()   // remove all the items from the list
    }

    fun removeCard(card: Card) {
        cards.remove(card)
    }

    fun addCard(card: Card): Boolean {
        // If foundation list is empty, the next card would be the ace (value of 0)
        var nextValue = 0
        // If there are cards in the foundation
        if (cards.size > 0) {
            // the nextValue property will have a value of the last card in foundation + 1
            nextValue = cards.last().value + 1
        }
        // Check if the suit matches the foundation suit and its value matches the next foundation card
        if (card.suit == suit && card.value == nextValue) {
            cards.add(card)   // if so, we add the card to the pile
            return true
        }
        return false
    }
}


    // The foundation pile has 3 action = Add a card, Remove a card, Reset to an empty pile