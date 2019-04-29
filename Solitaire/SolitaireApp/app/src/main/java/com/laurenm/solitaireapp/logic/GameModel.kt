package com.laurenm.solitaireapp.logic


object GameModel {
    val deck = Deck()
    val wastePile: MutableList<Card> = mutableListOf()  // empty
    val foundationPiles = arrayOf(
                            FoundationPile(clubs),
                            FoundationPile(diamonds),
                            FoundationPile(hearts),
                            FoundationPile(spades)
    )
    val tableauPiles = Array(7) { TableauPile() }

    /**
     * Reset game to starting state
     */
    fun resetGame() {
        // Empty waste pile
        wastePile.clear()
        // Clear each foundation pile
        foundationPiles.forEach({ it.reset() })  // only 1 parameter
        deck.reset()

        // Replace tableau piles with new ones (index 0, 1 card / index 1, 2 cards... until index 6, 7 cards)
        /*
        forEachIndexed - Params: action - function that takes the index of an element and the element itself and
        performs the desired action on the element.
        */
        tableauPiles.forEachIndexed { index, tableauPile ->
            val cardsInPile: MutableList<Card> =
                Array(index + 1) { deck.drawCard() }
                    .toMutableList()
            tableauPiles[index] = TableauPile(cardsInPile)
        }
    }

    fun onDeckTap() {
        if (deck.cardsInDeck.size > 0) {
            val card = deck.drawCard()
            card.faceUp = true
            wastePile.add(card)
        } else {
            // If the deck is empty, we add a copy of the wastePile to the deck, not the actual one
            deck.cardsInDeck = wastePile.toMutableList()
            // empty the wastePile
            wastePile.clear()
        }
    }

    fun onWasteTap() {
        if (wastePile.size > 0) {
            val card = wastePile.last()   // top card
            // If we can play the card, we remove it from the waste pile
            if (playCard(card)) {
                wastePile.remove(card)
            }
        }
    }

    fun onFoundationTap(foundationIndex: Int) {
        val foundationPile = foundationPiles[foundationIndex]
        if (foundationPile.cards.size > 0) {
            val card = foundationPile.cards.last()   // top card
            // If we can play the card, we remove it from the waste pile
            if (playCard(card)) {
                foundationPile.removeCard(card)
            }
        }
    }

    fun onTableauTap(tableauIndex: Int, cardIndex: Int) {
        val tableauPile = tableauPiles[tableauIndex]
        // If tableau pile is not empty, we get the index of the cards to move
        if (tableauPile.cards.size > 0) {
            // We only move cards facing up
            if (tableauPile.cards[cardIndex].faceUp) {
                val cards = tableauPile.cards.subList(
                    cardIndex,
                    tableauPile.cards.lastIndex + 1   // exclusive
                )
                if (playCards(cards)) {
                    tableauPile.removeCards((cardIndex))
                }
            }
        }
    }

    private fun playCards(cards: MutableList<Card>): Boolean {
        // If only one card, return playCard()
        if (cards.size == 1) {
            return playCard(cards.first())
        } else {
            // True if we can add the cards to a tableau pile
            tableauPiles.forEach {
                if (it.addCards(cards)) {
                    return true
                }
            }
        }
        return false
    }

    private fun playCard(card: Card): Boolean {
        // True if we can add the card to a foundation pile
        foundationPiles.forEach {
            if (it.addCard(card)) {
                return true
            }
        }
        // True if we can add the card to a tableau pile
        tableauPiles.forEach {
            if (it.addCards(mutableListOf(card))) {
                return true
            }
        }
        return false
    }

    fun debugPrint() {
        // Deck
        var firstLine = if (wastePile.size > 0 ) "${wastePile.last()}" else "___"
        // Space
        firstLine = firstLine.padEnd(18)  // 3 blocks of 6 chars each
        // 4 foundation piles (end of first row)
        foundationPiles.forEach {
            firstLine += if (it.cards.size > 0 ) "${it.cards.last()}" else "___"
            firstLine += "   "   // 3 spaces between our foundation piles
        }
        println(firstLine)
        println()
        // 7 foundation piles on 13 rows
        for (i in 0..12) {
            var row = ""
            tableauPiles.forEach {
                row += if (it.cards.size > i) "${it.cards[i]}" else "   "
                row += "   "   // 3 spaces padding between piles
            }
            println(row)
        }
//        // Get the top card
//        println(deck.cardsInDeck.last())
    }
}


// The waste pile has 3 actions = Add a card, Remove a card, Remove all cards

