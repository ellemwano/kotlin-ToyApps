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
    }

     // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type
     // to represent an item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {

        // DONE (01) Inflate the text_item_view layout.
         val layoutInflater = LayoutInflater.from(parent.context)
         val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView

        // DONE (02) Return the inflated view.
         return TextItemViewHolder(view)
    }
}