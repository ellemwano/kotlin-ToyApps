package com.mwano.lauren.funfacts

import android.graphics.Color
import kotlin.random.Random

internal class ColourWheel {

    private val colours = arrayOf(
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    )

    fun getColour() : Int {
        // Randomly select a fact
        val randomGenerator = Random
        val randomNumber = randomGenerator.nextInt(colours.size)
        val colourAsInt = Color.parseColor(colours[randomNumber])
        return colourAsInt
    }
}