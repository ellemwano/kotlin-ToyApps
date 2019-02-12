package com.mwano.lauren.funfacts

import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FunFactsActivity : AppCompatActivity() {
    //private val TAG = FunFactsActivity::class.java.simpleName
    private val factBook = FactBook()
    private val colourWheel = ColourWheel()
    private var factTextView: TextView? = null
    private var showFactButton: Button? = null
    private var constraintLayout: ConstraintLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun_facts)

        factTextView = findViewById(R.id.factTextView)
        showFactButton = findViewById(R.id.showFactButton)
        constraintLayout = findViewById(R.id.relativeLayout)

        showFactButton!!.setOnClickListener {
            val fact = factBook.getFact()
            val colour = colourWheel.getColour()

            // Update the screen with our new fact
            factTextView!!.text = fact
            constraintLayout!!.setBackgroundColor(colour)
            showFactButton!!.setTextColor(colour)
        }

        //Log.d(TAG, getString(R.string.Log_on_create_main))
    }
}
