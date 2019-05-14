package com.example.kotlinplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    val recyclerView by lazy { findViewById<RecyclerView>(R.id.recycler) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Showing a toast with title on click (extension function for toast)
        recyclerView.adapter = MediaAdapter(getMedia()) { (title) -> toast(title) }
    }
}


