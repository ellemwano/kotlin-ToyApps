/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.sleeptracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.TextItemViewHolder
import com.example.android.trackmysleepquality.database.SleepNight


class SleepNightAdapter : RecyclerView.Adapter<TextItemViewHolder>() {

    var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

     // Returns the total number of items in the data set held by the adapter
    override fun getItemCount() = data.size

     // Called by RecyclerView to display the data at the specified position.
     // This method should update the contents of the RecyclerView.ViewHolder.itemView
     // to reflect the item at the given position.
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
         val item = data[position]
         holder.textView.text = item.sleepQuality.toString()

         // DONE (01) Add an if block and set the sleep quality to red
         // if sleepQuality is 1 or less.
         // DONE (02) Run the app and see that color does not reset to black.
         // Set sleep rating colour to red when <= 1
         if (item.sleepQuality <= 1) {
             holder.textView.setTextColor(Color.RED)
         } else {
             // DONE (03) Add an else clause and reset the color if sleepQuality is 2 or higher.
             // DONE (04) Run the app again and verify that the color displays correctly
             // for all sleepQuality values.
             holder.textView.setTextColor(Color.BLACK)
         }
    }

     // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type
     // to represent an item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {

         // Create a layoutInflater based on the parent view and inflate the view
         val layoutInflater = LayoutInflater.from(parent.context)
         val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView

         // Return the inflated view
         return TextItemViewHolder(view)
    }
}