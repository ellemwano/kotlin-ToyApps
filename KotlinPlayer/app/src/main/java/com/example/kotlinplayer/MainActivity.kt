package com.example.kotlinplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Showing a toast with title on click (extension function for toast)
        recycler.adapter = MediaAdapter(getMedia()) { mediaItem ->  toast(mediaItem.title) }
    }
}


