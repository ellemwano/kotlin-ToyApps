package com.laurenm.solitaireapp

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import com.laurenm.solitaireapp.logic.GameModel
import com.laurenm.solitaireapp.logic.GamePresenter
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.sdk27.coroutines.onClick


/**
 * Custom view for the deck
 */
class DeckView(context: Context) : ImageView(context) {
    init {
        imageResource = cardBackDrawable
        onClick {
            GamePresenter.onDeckTap()
        }
    }

    fun update() {
        // cards in deck
        val cards= GameModel.deck.cardsInDeck
        // different image if deck is empty or not
        imageResource = if (cards.size > 0) cardBackDrawable else emptyPileDrawable
    }
}

fun ViewManager.deckView(init: DeckView.() -> Unit = {}) =
    ankoView({ DeckView(it)}, 0, init)

//val DECKVIEW_FACTORY = { ctx: Context -> DeckView(ctx)}
//fun ViewManager.deckView(init: DeckView.() -> Unit = {}) =
//        ankoView(DECKVIEW_FACTORY, 0, init)