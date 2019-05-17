package com.example.kotlinplayer

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


object MediaProvider {

    private val thumbBase = "http://lorempixel.com/400/400//"

    private var data = emptyList<MediaItem>()

    /*
      Without coroutines
     */
//    fun dataAsync(type: String = "cats", callback: (List<MediaItem>) -> Unit) {
//        doAsync {
//            if (data.isEmpty()) {
//                Thread.sleep(2000)
//                data = (1..10).map {
//                    MediaItem(it,
//                        "Title $it",
//                        "$thumbBase$type/$it",
//                        if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO)
//                }
//            }
//            uiThread {
//                callback(data)
//            }
//        }
//    }

    /*
      With coroutines
     */
    fun dataAsync(type: String = "cats", callback: (List<MediaItem>) -> Unit) {
        doAsync {
            if (data.isEmpty()) {
                data = dataSync(type)
            }
            uiThread {
                callback(data)
            }
        }
    }

    fun dataSync(type:String): List<MediaItem> {
        Thread.sleep(2000)
        return (1..10).map {
            MediaItem(
                it,
                "Title $it",
                "$thumbBase$type/$it",
                if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
            )
        }
    }
}



