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

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight


class SleepNightAdapter : RecyclerView.Adapter<SleepNightAdapter.ViewHolder>() {

    var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type
    // to represent an item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

     // Called by RecyclerView to display the data at the specified position.
     // This method should update the contents of the RecyclerView.ViewHolder.itemView
     // to reflect the item at the given position.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val item = data[position]
         holder.bind(item)
     }

    // Returns the total number of items in the data set held by the adapter
    override fun getItemCount() = data.size


    // Private constructor - Can only be called inside the class (won't be called outside with from())
    class ViewHolder private constructor(itemView: View) :  RecyclerView.ViewHolder(itemView) {
        // DONE (01) Refactor the logic for creating the ViewHolder into a function called from().

        // DONE (02) Make the from() function into a companion object.

        // DONE (03) Move the companion object into the ViewHolder class, and have it
        // return a ViewHolder.

        val sleepLength: TextView = itemView.findViewById(R.id.sleep_length)
        val quality: TextView = itemView.findViewById(R.id.quality_string)
        val qualityImage: ImageView = itemView.findViewById(R.id.quality_image)

        // We use a Companion object as this needs to be called on the VH class, not an instance
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                // Create a layoutInflater based on the parent view and inflate the view
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.list_item_sleep_night, parent, false)

                // Return the inflated view
                return ViewHolder(view)
            }
        }

        fun bind(item: SleepNight) {
            val res = itemView.context.resources
            sleepLength.text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
            quality.text = convertNumericQualityToString(item.sleepQuality, res)
            qualityImage.setImageResource(when (item.sleepQuality) {
                0 -> R.drawable.ic_sleep_0
                1 -> R.drawable.ic_sleep_1
                2 -> R.drawable.ic_sleep_2
                3 -> R.drawable.ic_sleep_3
                4 -> R.drawable.ic_sleep_4
                5 -> R.drawable.ic_sleep_5
                else -> R.drawable.ic_sleep_active
            })
        }
    }
}