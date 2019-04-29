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
 * Custom view for the 4 foundation piles
 */
class FoundationPileView(context: Context, val index: Int) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onFoundationTap(index)
        }
    }

    fun update() {
        // cards in waste pile
        val cards = GameModel.foundationPiles[index].cards
        // different image if foundation pile is empty or not
        imageResource = if (cards.size > 0) getResIdForCard(cards.last()) else emptyPileDrawable
    }
}

fun ViewManager.foundationPileView(index: Int, init: FoundationPileView.() -> Unit = {}) =
    ankoView({ FoundationPileView(it, index) }, 0, init)