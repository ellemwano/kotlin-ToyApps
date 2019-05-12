package com.example.kotlinplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Extension function
        toast("Hello")
        toast("Hello", Toast.LENGTH_LONG)
    }
}

