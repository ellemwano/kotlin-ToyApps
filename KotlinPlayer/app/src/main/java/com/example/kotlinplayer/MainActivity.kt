package com.example.kotlinplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set toast message
        toast("Hello")

        // Set textView text
        val textView = findViewById<TextView>(R.id.textview)
//        val textView = findViewById(R.id.textview) as TextView  // Pre-API 26
        textView.text = "Hello Kotlin!"
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    /*
    2 ways to write functions:
     */

    fun getInt1(int: Int): Int {
        return 2 * int
    }

    fun getInt2(int: Int) = 2 * int   // For simple functions


    /*
    Variables
     */

    fun test() {
        // Inferred types
        val x = 20    // Int
        val y = 20f   // Float
        val z = 20.0  // Double
        val a = 20L   // Long
        var string = "Hello"
        // Conversion
        val b: Long = x.toLong()
    }
}
