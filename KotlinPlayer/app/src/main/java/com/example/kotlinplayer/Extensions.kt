package com.example.kotlinplayer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso


fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun RecyclerView.ViewHolder.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    itemView.context.toast(message, length)
}

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun ImageView.loadUrl(url: String) =
    Picasso.get()
        .load(url)
        .into(this)

inline fun <reified T: View> View.find(idRes: Int) : T {
    return findViewById(idRes)
}

inline fun <reified T: View> RecyclerView.ViewHolder.find(idRes: Int) : T {
    return itemView.find(idRes)
}