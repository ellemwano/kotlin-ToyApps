package com.laurenm.solitaireapp

import android.content.Context
import android.view.ViewManager
import com.laurenm.solitaireapp.logic.GameModel
import com.laurenm.solitaireapp.logic.GamePresenter
import org.jetbrains.anko._RelativeLayout
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.dip
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.imageView
import org.jetbrains.anko.sdk27.coroutines.onClick


/**
 * Custom view for the tableau piles
 */
class TableauPileView(context: Context, val index: Int) : _RelativeLayout(context) {
    init {
        addViews()
    }


    fun update() {
        removeAllViews()
        addViews()
    }

    private fun addViews() {
        // Cards for a given pile
        val cards = GameModel.tableauPiles[index].cards
        cards.forEachIndexed { i, card ->
            imageView{
                // vertical position of this view inside its parents
                y = (i * dip(25)).toFloat()
                // different image if card is facing up or down
                imageResource = if (card.faceUp) getResIdForCard(card) else cardBackDrawable
                onClick {
                    GamePresenter.onTableauTap(index, i)
                }

            }.lparams(context.cardWidth, context.cardHeight)
        }
    }
}

fun ViewManager.tableauPileView(index: Int, init: TableauPileView.() -> Unit = {}) =
    ankoView({ TableauPileView(it, index) }, 0, init)