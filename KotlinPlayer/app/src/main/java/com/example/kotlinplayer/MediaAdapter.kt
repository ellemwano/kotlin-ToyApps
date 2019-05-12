package com.example.kotlinplayer

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class MediaAdapter(val items: List<MediaItem>) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_media_item)  // Function extension
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Reified functions
        val title = view.find<TextView>(R.id.media_title) // Not much difference since API 26
        val image = find<ImageView>(R.id.media_thumb)  // Using the ViewHolder function extension

        fun bind(item: MediaItem) {
            title.text = item.title
            image.loadUrl(item.thumbUrl)  // Extension function

            toast("Hello")  // Extension function
        }
    }
}