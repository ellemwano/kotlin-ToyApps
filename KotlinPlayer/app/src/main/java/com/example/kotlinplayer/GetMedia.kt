package com.example.kotlinplayer

private val thumbBase = "http://lorempixel.com/400/400/cats/"

// map - Returns a list containing the results of applying the given transform function to each element
// in the original collection.
fun getMedia() = (1..10).map {
    MediaItem("Title $it",
        "$thumbBase$it",
        if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO)
}