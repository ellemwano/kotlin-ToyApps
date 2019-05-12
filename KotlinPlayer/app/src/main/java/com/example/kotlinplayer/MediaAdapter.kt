package com.example.kotlinplayer

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_media_item.view.*


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

          // Using the Android Extension (if we want them cached into properties)
//        val title = view.media_title
//        val image = view.media_thumb
//        val videoIndicator = view.media_video_indicator

        // Using Android extensions
        fun bind(item: MediaItem) {
            itemView.media_title.text = item.title
            itemView.media_thumb.loadUrl(item.thumbUrl)
            // If video, we show the play video icon on top
            itemView.media_video_indicator.visibility = when(item.type) {
                MediaItem.Type.VIDEO -> View.VISIBLE
                MediaItem.Type.PHOTO -> View.GONE
            }
        }
    }
}