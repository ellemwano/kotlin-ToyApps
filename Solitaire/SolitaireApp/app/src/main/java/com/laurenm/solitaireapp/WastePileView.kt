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
 * Custom view for the waste pile
 */
class WastePileView(context: Context) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onWasteTap()
        }
    }

    fun update() {
        // cards in waste pile
        val cards = GameModel.wastePile
        // different image if waste pile is empty or not (= last image picked)
        imageResource = if (cards.size > 0) getResIdForCard(cards.last()) else emptyPileDrawable
    }
}

fun ViewManager.wastePileView(init: WastePileView.() -> Unit = {}) =
    ankoView({ WastePileView(it) }, 0, init)