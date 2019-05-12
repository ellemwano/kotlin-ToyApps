package com.example.kotlinplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), Logger {

//   override val tag: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.message)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            toast("Hello ${editText.text}")  // String template
        }

        // Debug log (using Logger interface)
        d("Hello")
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}


/*
  Interface for logs
 */
interface  Logger {

    val tag: String
        get() = javaClass.simpleName

    fun d(message: String) = Log.d(tag, message)

}
