package com.example.kotlinplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    val adapter = MediaAdapter { navigateToDetail(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.adapter = adapter
        MediaProvider.dataAsync { adapter.items = it }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       val filter: Filter = when (item.itemId) {
                R.id.filter_photos -> Filter.ByType(MediaItem.Type.PHOTO)
                R.id.filter_videos -> Filter.ByType(MediaItem.Type.VIDEO)
                else -> Filter.None
       }

        loadFilterData(filter)

        return true
    }

    /*
      With coroutines
     */
    private fun loadFilterData(filter: Filter) {

        // Create coroutine
        GlobalScope.launch {
            val media1 = MediaProvider.dataSync("cats")
            val media2 = MediaProvider.dataSync("nature")
            updateData(media1 + media2, filter)
        }
    }

    /*
      Without coroutines
     */
//    private fun loadFilterData(filter: Filter) {
//        MediaProvider.dataAsync("cats") {  media1 ->
//
//            MediaProvider.dataAsync("nature") { media2 ->
//
//                // Update data
//                updateData(media1 + media2, filter)
//                }
//            }
//        }
//    }

    private fun updateData(media: List<MediaItem>, filter: Filter = Filter.None ) {
        adapter.items = when(filter) {
            Filter.None -> media
            is Filter.ByType -> media.filter { it.type == filter.type }
        }
    }

    private fun navigateToDetail(item: MediaItem) {
        // Using Anko
        startActivity<DetailActivity>(DetailActivity.ID to item.id)
    }
}


