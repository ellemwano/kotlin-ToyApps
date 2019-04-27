/**
 * The 7 piles at the bottom of the game
 */

class TableauPile(var cards: MutableList<Card> = mutableListOf())  {
    init {
        if (cards.size > 0) {
            cards.last().faceUp = true
        }
    }

    fun addCards(newCards: MutableList<Card>): Boolean {
        // If there are cards in the tableauPile
        if (cards.size > 0) {
            // If the value of the newCard is one more than the last from foundationPile
            // And if they're of different colour
            if (newCards.first().value == cards.last().value - 1 &&
                suitCheck(newCards.first(), cards.last())
            ) {
                cards.addAll(newCards)  // several cards can be added (moved around)
                return true    // tell model it' a sucess
            }
        // If the tableauPile is empty and the first newCard is a King
        } else if (newCards.first().value == 12) {
            cards.addAll(newCards)
            return true
        }
        return false
    }

    fun removeCards(tappedIndex: Int) {
//        for (i in tappedIndex..cards.lastIndex) {
//            cards.removeAt(tappedIndex)
//        }
        for (i in cards.lastIndex downTo tappedIndex) {  // clearer
            cards.removeAt(i)
        }
        // If there are cards left in the pile, we make sure the last one is face up
        if (cards.size > 0) {
            cards.last().faceUp = true
        }
    }

    private fun suitCheck(c1: Card, c2: Card): Boolean {
       return (redSuits.contains(c1.suit) && blackSuits.contains(c2.suit)) ||
            (blackSuits.contains(c1.suit) && redSuits.contains(c2.suit))
    }


}




// The Tableau pile contains cards right from the start, so cards are delared in the constructor
// The last card needs to be face up
// The actions are : Remove one card, Add one card, Remove multiple cards between tableauPiles
// When resetting the game, we'll create new tableauPiles instead of re-using them. So no reset method here
// An empty tableauPile will only accept teh King as teh first card